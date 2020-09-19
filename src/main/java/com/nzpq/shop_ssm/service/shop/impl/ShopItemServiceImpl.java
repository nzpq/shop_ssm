package com.nzpq.shop_ssm.service.shop.impl;

import com.nzpq.shop_ssm.domain.CartInfo;
import com.nzpq.shop_ssm.domain.QueryVO;
import com.nzpq.shop_ssm.mapper.shop.ShopItemMapper;
import com.nzpq.shop_ssm.pojo.*;
import com.nzpq.shop_ssm.service.shop.ShopItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShopItemServiceImpl implements ShopItemService {

    @Autowired
    private ShopItemMapper shopItemMapper;
    //日志
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private ItemOrder itemOrder;
    @Autowired
    private OrderDetail orderDetail;

    /**
     * 根据二级分类id或者用户输入的参数进行查询商品
     * @param id
     * @param condition
     * @return
     */
    @Override
    public List<Item> findItems(Integer id, String condition) {
        QueryVO vo = new QueryVO();//参数
        if(id != null){
            vo.setId(id);
        }
        if(condition != null && !"".equals(condition)){
            vo.setCondition(condition);
        }

        logger.info(vo);
        return shopItemMapper.findItems(vo);

    }

    /**
     * 添加收藏
     * @param
     */
    @Override
    public void addFavorite(Favorite favorite) {
        //获取用户id

        shopItemMapper.addFavorite(favorite);
        //根据商品id查询出一个，然后让其收藏数+1
        Item item = shopItemMapper.findOneItem(favorite.getItemId());
        item.setScNum(item.getScNum() + 1);
        shopItemMapper.updateFavoriteNum(item);

    }

    /**
     * 查找收藏
     * @param uid
     * @return
     */
    @Override
    public List<Item> showFavorite(Integer uid) {
        List<Item> list = shopItemMapper.findUserFavorite(uid);
        return list;
    }

    /**
     * 取消收藏
     * @param favorite
     */
    @Override
    public void removeFavorite(Favorite favorite) {
        //取消用户收藏
        shopItemMapper.removeFavorite(favorite);
        //该商品收藏数减一
        Item item = shopItemMapper.findOneItem(favorite.getItemId());
        item.setScNum(item.getScNum() - 1);
        shopItemMapper.updateFavoriteNum(item);
    }

    /**
     * 进入购物车
     * @param id
     */
    @Override
    public List<CartInfo> findCar(Integer id) {
        List<CartInfo> list = shopItemMapper.findCar(id);
        return list;
    }

    /**
     * 添加购物车
     * @param itemId
     */
    @Override
    public void addCar(Integer itemId,Integer uid) {
        //先判断购物车中是否已有改商品，如果有则数量加一
        Car itemInCar = shopItemMapper.findItemInCar(itemId, uid);
        if(itemInCar == null){
            //用户没有收藏该商品
            Car car = new Car();
            Item oneItem = shopItemMapper.findOneItem(itemId);
            System.out.println(oneItem);
            car.setItem_id(itemId);
            car.setUser_id(uid);
            car.setNum(1);
            car.setPrice(new BigDecimal(oneItem.getPrice()));
            car.setTotal(new BigDecimal(car.getNum()).multiply(car.getPrice()));
            shopItemMapper.addCar(car);
        }else{
            //用户已收藏该商品
            //查询出该记录并为其数量加一，总价钱也得更新
            Car car = shopItemMapper.findByIdAndUid(itemId,uid);
            car.setNum(car.getNum() + 1);
            car.setTotal(car.getPrice().multiply(BigDecimal.valueOf(car.getNum())));
            shopItemMapper.updateCarNum(car);
        }
    }

    /**
     * 从购物车移除一个商品
     * @param itemId
     */
    @Override
    public void removeCar(Integer itemId,Integer uid) {
        shopItemMapper.removeCar(itemId,uid);
    }

    /**
     * 展示商品详情，封装该商品对应的评论
     * @param id
     * @return
     */
    @Override
    public Item findItemDetail(Integer id) {
        Item item = shopItemMapper.findItemDetail(id);//查询商品详情
        List<Comment> comments = shopItemMapper.findItemComment(id);//该商品对应的评论
        //封装每条评论对应的用户信息
        for(Comment comment : comments){
            User user = shopItemMapper.findUser(comment.getUser_id());
            comment.setUser(user);
        }
        item.setComments(comments);
        return item;
    }

    /**
     * 从商品详情页添加进购物车
     * @param car
     */
    @Override
    public void addCars(Car car) {
        Item item = shopItemMapper.findOneItem(car.getItem_id());
        car.setPrice(new BigDecimal(item.getPrice()));
        car.setTotal(new BigDecimal(car.getNum()).multiply(car.getPrice()));
        shopItemMapper.addCar(car);
    }

    /**
     * 更新购物车中商品的数量
     * @param car
     */
    @Override
    public void updateItemNum(Car car) {
        Item item = shopItemMapper.findOneItem(car.getItem_id());// 查出该商品，需要用到该商品的价格
        car.setPrice(new BigDecimal(item.getPrice()));
        car.setTotal(new BigDecimal(item.getPrice()).multiply(new BigDecimal(car.getNum())));
        shopItemMapper.updateCarNum(car);
    }

    /**
     * 提交订单
     * @param list
     * @param user
     */
    @Override
    public void addItemOrder(List<Car> list,User user) {
        //封装订单
        BigDecimal total = new BigDecimal(0);
        //封装从数据库中查出来的购物车的所有信息，用于插入订单详情表
        List<Car> cars = new ArrayList<>();
        //判断用户是否设置了收货地址
        User userDB = shopItemMapper.findUser(user.getId());
        logger.info("==========="+userDB);
        if(userDB.getAddress() == null || "".equals(userDB.getAddress())){
            throw new RuntimeException("请前往个人中心编辑收货地址");
        }
        ///封装订单总价
        for(Car car : list){
            Car oneCar = shopItemMapper.findOneCar(car.getId());
            //更新购物车中的数量
            oneCar.setNum(car.getNum());
            oneCar.setTotal(BigDecimal.valueOf(oneCar.getNum()).multiply(oneCar.getPrice()));
            shopItemMapper.updateCarNum(oneCar);
            total = total.add(oneCar.getTotal());
            cars.add(oneCar);

        }
        itemOrder.setTotal(total.toString());
        itemOrder.setUser_id(user.getId());
        //封装订单号
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        itemOrder.setCode(format.format(new Date()));
        //订单创建时间
        itemOrder.setId((int) new Date().getTime());
        itemOrder.setAddTime(new Date());
        itemOrder.setIsDelete(0);//未删除
        itemOrder.setStatus(4);//待付款状态
        logger.info("**********"+itemOrder);
        //调用mapper添加订单，返回该订单的id
        shopItemMapper.addOrder(itemOrder);
        Integer orderId = itemOrder.getId();
        logger.info(orderId+"**********"+itemOrder);
        //添加订单详情
        for(Car car : cars){
            //封装订单详情
            orderDetail.setId((int) new Date().getTime());
            orderDetail.setItem_id(car.getItem_id());
            orderDetail.setOrder_id(itemOrder.getId());
            orderDetail.setStatus(0);
            orderDetail.setNum(car.getNum());
            orderDetail.setTotal(car.getTotal().toString());
            //插入
            shopItemMapper.addItemDetail(orderDetail);
            //删除购物车中已经提交订单的数据
            shopItemMapper.removeCar(car.getItem_id(),user.getId());
        }
    }

    @Override
    public List<ItemOrder> findAllMyOrder(Integer uid,Integer status) {
        //封装ItemOrder
        List<ItemOrder> list = shopItemMapper.findAllMyOrder(uid,status);
        for(ItemOrder itemOrder : list){
            List<OrderDetail> itemDetails = shopItemMapper.findItemDetails(itemOrder.getId());
            //封装每个订单详情对应的商品信息
            for(OrderDetail orderDetail : itemDetails){
                Item oneItem = shopItemMapper.findOneItem(orderDetail.getItem_id());
                orderDetail.setItem(oneItem);
            }
            itemOrder.setDetails(itemDetails);
        }
        return list;
    }

    /**
     * 取消订单
     * @param id
     */
    @Override
    public void deleteOrder(Integer id) {
        shopItemMapper.deleteOrder(id);
    }

    /**
     * 付款
     * @param id
     */
    @Override
    public void payOrder(Integer id) {
        shopItemMapper.payOrder(id);
    }

    /**
     * 收货
     * @param id
     */
    @Override
    public void getOrder(Integer id) {
        shopItemMapper.getOrder(id);
    }

    /**
     * 添加评价
     * @param comment
     */
    @Override
    public void addComment(Comment comment) {
        shopItemMapper.addComment(comment);
    }

    /**
     * 查找用户对应商品的评价，判断是否已经评价过
     * @param uid
     * @param itemId
     */
    @Override
    public void findComment(Integer uid,Integer itemId){
        Comment comment = shopItemMapper.findComment(uid, itemId);
        if(comment != null){
            throw new RuntimeException("你已评价过了！");
        }
    }

}
