package com.nzpq.shop_ssm.mapper.shop;

import com.nzpq.shop_ssm.domain.CartInfo;
import com.nzpq.shop_ssm.domain.QueryVO;
import com.nzpq.shop_ssm.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopItemMapper {
    /**
     * 根据二级分类id或者用户搜索框传递进来的参数进行查询
     * @param vo
     * @return
     */
    List<Item> findItems(QueryVO vo);

    /**
     * 添加收藏
     *
     */
    void addFavorite(Favorite favorite);


    /**
     * 改变商品被收藏数
     * @param
     * @return
     */
    void updateFavoriteNum(Item item);

    /**
     * 根据id查询一个商品
     * @param
     */
    Item findOneItem(Integer id);

    /**
     * 查询用户收藏
     * @param uid
     */
    List<Item> findUserFavorite(Integer uid);

    /**
     * 取消收藏
     * @param favorite
     */
    void removeFavorite(Favorite favorite);

    /**
     * 查找购物车的商品
     * @return
     */
    List<CartInfo> findCar(@Param("id") Integer id);

    /**
     *查询购物车中是否有该商品
     * @param id
     * @param uid
     */
    Car findItemInCar(@Param("id") Integer id, @Param("uid") Integer uid);

    /**
     * 第一次添加购物车
     * @param car
     */
    void addCar(Car car);

    /**
     * 根据用户id和商品id查询一条记录
     * @param uid
     * @param itemId
     * @return
     */
    Car findByIdAndUid( @Param("itemId") Integer itemId,@Param("uid") Integer uid);

    /**
     * 为收藏数量加一
     * @param car
     */
    void updateCarNum(Car car);

    /**
     * 删除购物车一件商品
     * @param itemId
     * @param uid
     */
    void removeCar(@Param("itemId") Integer itemId,@Param("uid") Integer uid);

    /**
     * 查询商品详情
     * @param id
     * @return
     */
    Item findItemDetail(Integer id);

    /**
     * 查询商品留言
     * @param id
     * @return
     */
    List<Comment> findItemComment(Integer id);

    /**
     * 查找一个用户，用户封装每条留言对应的用户信息
     * @param user_id
     * @return
     */
    User findUser(Integer user_id);

    /**
     * 查找出一条购物车记录
     * @param id
     * @return
     */
    Car findOneCar(Integer id);

    /**
     * 添加订单
     * @param itemOrder
     */
    void addOrder(ItemOrder itemOrder);

    /**
     * 添加订单详情表
     * @param orderDetail
     */
    void addItemDetail(OrderDetail orderDetail);

    /**
     * 查找我的所有订单
     * @param uid
     * @return
     */
    List<ItemOrder> findAllMyOrder(@Param("uid") Integer uid,@Param("status") Integer status);

    /**
     * 查找该订单对应的订单详情
     * @param id
     * @return
     */
    List<OrderDetail> findItemDetails(Integer id);

    /**
     * 取消订单
     * @param id
     */
    void deleteOrder(Integer id);

    /**
     * 订单付款
     * @param id
     */
    void payOrder(Integer id);

    /**
     * 收货
     * @param id
     */
    void getOrder(Integer id);
    /**
     * 添加评价
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 判断该用户是否已评价过该商品
     * @param uid
     * @param itemId
     */
    Comment findComment(@Param("uid") Integer uid, @Param("itemId") Integer itemId);
}
