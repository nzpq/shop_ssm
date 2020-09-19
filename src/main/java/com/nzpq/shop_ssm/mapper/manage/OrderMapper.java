package com.nzpq.shop_ssm.mapper.manage;

import com.nzpq.shop_ssm.pojo.Item;
import com.nzpq.shop_ssm.pojo.ItemOrder;
import com.nzpq.shop_ssm.pojo.OrderDetail;
import com.nzpq.shop_ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * 查询所有订单
     * @return
     */
    List<ItemOrder> findAll(@Param("code") String code);

    /**
     * 根据订单中的用户id查询一个用户，封装在订单类中对应的用户信息
     * @param user_id
     * @return
     */
    User findUserById(Integer user_id);

    /**
     * 发货，修改status为2
     * @param id
     */
    void sendGoods(Integer id);

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    List<OrderDetail> findOrderDetail(Integer id);

    /**
     * 根据id查询商品
     * @param itemId
     * @return
     */
    Item findItemById(Integer itemId);
}
