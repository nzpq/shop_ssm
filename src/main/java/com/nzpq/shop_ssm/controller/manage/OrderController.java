package com.nzpq.shop_ssm.controller.manage;

import com.github.pagehelper.PageInfo;
import com.nzpq.shop_ssm.pojo.ItemOrder;
import com.nzpq.shop_ssm.pojo.OrderDetail;
import com.nzpq.shop_ssm.service.manage.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    //日志
    Logger logger = Logger.getLogger(this.getClass());
    /**
     * 查询所有订单
     * @return
     */
    @RequestMapping("/findAllOrder")
    public String findAllOrder(@RequestParam(name="page",defaultValue = "1") Integer page,
                               @RequestParam(name = "size",defaultValue = "20") Integer size,
                               @RequestParam(name = "code",required = false) String code,
                               Model model){
        List<ItemOrder> list = orderService.findAllOrder(page,size,code);
        PageInfo<ItemOrder> info = new PageInfo<>(list);
        model.addAttribute("info",info);
        return "manage/itemOrder";
    }

    /**
     * 发货
     * @return
     */
    @RequestMapping("/sendGoods")
    public String sendGoods(Integer id){
        orderService.sendGoods(id);
        return "redirect:findAllOrder";
    }

    /**
     * 查询该订单下对应的商品
     * @return
     */
    @RequestMapping("/findOrderItem")
    public String findOrderItem(Integer id,Model model){
        List<OrderDetail> list = orderService.findOrderDetail(id);
//        logger.info(list);
        model.addAttribute("list",list);
        return "manage/orderDetail";
    }
}
