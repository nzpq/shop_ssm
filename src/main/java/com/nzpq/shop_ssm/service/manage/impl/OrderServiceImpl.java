package com.nzpq.shop_ssm.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.shop_ssm.mapper.manage.OrderMapper;
import com.nzpq.shop_ssm.pojo.Item;
import com.nzpq.shop_ssm.pojo.ItemOrder;
import com.nzpq.shop_ssm.pojo.OrderDetail;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.manage.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询所有订单
     * @return
     */
    @Override
    public List<ItemOrder> findAllOrder(Integer page,Integer size,String code) {
        PageHelper.startPage(page,size);
        //封装ItemOrder
        List<ItemOrder> list = orderMapper.findAll(code);
        //查询该订单对应的用户信息
        for(ItemOrder order : list){
            User user = orderMapper.findUserById(order.getUser_id());
            order.setUser(user);
        }

        return list;
    }

    /**
     * 发货
     * @param id
     */
    @Override
    public void sendGoods(Integer id) {
        orderMapper.sendGoods(id);
    }

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    @Override
    public List<OrderDetail> findOrderDetail(Integer id) {
        //根据订单id查询一个订单详情的集合
        List<OrderDetail> list = orderMapper.findOrderDetail(id);
        //封装每个订单详情对应的商品
        for(OrderDetail detail : list){
            Item item = orderMapper.findItemById(detail.getItem_id());
            detail.setItem(item);
        }
        return list;
    }
}
