package com.nzpq.shop_ssm.service.manage;

import com.nzpq.shop_ssm.pojo.ItemOrder;
import com.nzpq.shop_ssm.pojo.OrderDetail;

import java.util.List;

public interface OrderService {
    List<ItemOrder> findAllOrder(Integer page,Integer size,String code);

    void sendGoods(Integer id);

    List<OrderDetail> findOrderDetail(Integer id);
}
