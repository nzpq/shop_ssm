package com.nzpq.shop_ssm.controller.shop;

import com.nzpq.shop_ssm.domain.CartInfo;
import com.nzpq.shop_ssm.pojo.*;
import com.nzpq.shop_ssm.service.shop.ShopItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commodity")
public class ShopItemController {

    @Autowired
    private ShopItemService shopItemService;
    //日志
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 根据二级分类id和用户搜索框的参数进行商品展示
     * @param id
     * @param condition
     * @param model
     * @return
     */
    @RequestMapping("/findItems")
    public String findItems(@RequestParam(name = "id",required = false) Integer id,
                            @RequestParam(name = "condition",required = false) String condition,
                            Model model){
        List<Item> list = shopItemService.findItems(id,condition);
        model.addAttribute("list",list);
        logger.info(list);
        return "shop/itemList";
    }

    /**
     *添加收藏
     * @param
     * @return
     */
    @RequestMapping("/addFavorite")
    public String addFavorite(Favorite favorite,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        favorite.setUserId(user.getId());
        logger.info("======"+favorite);
        shopItemService.addFavorite(favorite);
        return "redirect:/commodity/showFavorite";
    }

    /**
     * 展示收藏
     * @return
     */
    @RequestMapping("/showFavorite")
    public String showFavorite(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<Item> list = shopItemService.showFavorite(user.getId());
        model.addAttribute("list",list);
        return "shop/myFavorite";
    }

    /**
     * 取消收藏
     * @param
     * @return
     */
    @RequestMapping("/removeFavorite")
    public String removeFavorite(Favorite favorite,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        favorite.setUserId(user.getId());
        shopItemService.removeFavorite(favorite);
        return "redirect:/commodity/showFavorite";
    }

    /**
     * 进入购物车
     * @return
     */
    @RequestMapping("/findMyCar")
    public String findMyCar(HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<CartInfo> list = shopItemService.findCar(user.getId());
        model.addAttribute("list",list);
        return "shop/car";
    }

    /**
     * 添加购物车
     * @return
     */
    @RequestMapping("/addCar")
    public String addCar(HttpServletRequest request,Integer itemId){
        User user = (User) request.getSession().getAttribute("user");
        shopItemService.addCar(itemId,user.getId());

        return "redirect:/commodity/findMyCar";
    }

    /**
     * 移除购物车，移除一个
     * @return
     */
    @RequestMapping("/removeCar")
    public String removeCar(HttpServletRequest request,Integer itemId){
        User user = (User) request.getSession().getAttribute("user");
        shopItemService.removeCar(itemId,user.getId());

        return "redirect:/commodity/findMyCar";
    }

    /**
     * 查询商品详情
     * @param id 商品id
     * @return
     */
    @RequestMapping("/findItemDetail")
    public String findItemDetail(Integer id,Model model){
        Item item = shopItemService.findItemDetail(id);
        model.addAttribute("item",item);
        return "shop/itemDetail";
    }

    /**
     * 在商品详情页添加进购物车
     * @param car
     * @param request
     * @return
     */
    @RequestMapping("/addCars")
    public String addCars(Car car, HttpServletRequest request){

        User user = (User) request.getSession().getAttribute("user");
        car.setUser_id(user.getId());
        shopItemService.addCars(car);

        return "redirect:/commodity/findMyCar";
    }

    /**
     * 修改购物车中商品的数量
     */
    @RequestMapping("/updateItemNum")
    @ResponseBody
    public void updateItemNum(Car car, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        car.setUser_id(user.getId());
        logger.info("=========="+car);
//        shopItemService.updateItemNum(car);
    }

    /**
     * 生成订单
     * @param
     * @return
     */
    @RequestMapping("/itemOrder")
    @ResponseBody
    public Map<String,Object> itemOrder(@RequestBody List<Car> list, HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        logger.info(list);
        try {
            shopItemService.addItemOrder(list,user);
        } catch (Exception e) {
            map.put("msg",1);
            map.put("info",e.getMessage());
            logger.error(e);
            e.printStackTrace();
        }
        return map;
    }

    /**
     *查找我的订单
     * @param model
     * @return
     */
    @RequestMapping("/findMyOrder")
    public String findMyOrder(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        //查询所有订单
        List<ItemOrder> list = shopItemService.findAllMyOrder(user.getId(),-1);
        //查询已取消订单
        List<ItemOrder> Cancels = shopItemService.findAllMyOrder(user.getId(),1);
        //查询待发货订单
        List<ItemOrder> sends = shopItemService.findAllMyOrder(user.getId(),0);
        //查询待收货订单
        List<ItemOrder> receiv = shopItemService.findAllMyOrder(user.getId(),2);
        //查询已收货订单
        List<ItemOrder> isReceiv = shopItemService.findAllMyOrder(user.getId(),3);
        //查询待付款订单
        List<ItemOrder> pays = shopItemService.findAllMyOrder(user.getId(),4);

        model.addAttribute("list",list);
        model.addAttribute("Cancels",Cancels);
        model.addAttribute("sends",sends);
        model.addAttribute("receiv",receiv);
        model.addAttribute("isReceiv",isReceiv);
        model.addAttribute("pays",pays);

        logger.info("======"+list);
        return "shop/myOrder";
    }

    /**
     * 取消订单
     * @param id
     * @return
     */
    @RequestMapping("/deleteOrder")
    public String deleteOrder(Integer id){
        shopItemService.deleteOrder(id);
        logger.info("======="+id);
        return "redirect:/commodity/findMyOrder";
    }

    /**
     * 付款
     * @return
     */
    @RequestMapping("/payOrder")
    public String payOrder(Integer id){
        shopItemService.payOrder(id);
        return "redirect:/commodity/findMyOrder";
    }

    /**
     * 收货
     * @param id
     * @return
     */
    @RequestMapping("/getOrder")
    public String getOrder(Integer id){
        shopItemService.getOrder(id);
        return "redirect:/commodity/findMyOrder";
    }

    /**
     * 携带商品id跳转到评价页面
     * @param itemId
     * @return
     */
    @RequestMapping("/toComment")
    public String comment(Integer itemId,Model model, HttpServletRequest request){

        //先判断该用户是否已经评价过
//        try {
//            User user = (User) request.getSession().getAttribute("user");
//            shopItemService.findComment(user.getId(),itemId);
            model.addAttribute("itemId",itemId);
//        } catch (Exception e) {
//            model.addAttribute("msg",e.getMessage());
//            findMyOrder(model,request);
//        }
        return "shop/comment";
    }

    /**
     * 添加评价
     * @return
     */
    @RequestMapping("/addComment")
    public String addComment(Comment comment, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        comment.setUser_id(user.getId());
        comment.setAddTime(new Date());
        shopItemService.addComment(comment);
        return "redirect:/commodity/findMyOrder";
    }
}
