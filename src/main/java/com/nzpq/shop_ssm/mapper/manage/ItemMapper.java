package com.nzpq.shop_ssm.mapper.manage;

import com.nzpq.shop_ssm.pojo.Item;

import java.util.List;

public interface ItemMapper {
    /**
     * 查询所有商品信息
     * @param item
     * @return
     */
    List<Item> findAllItem(Item item);

    /**
     * 下架商品
     * @param id
     */
    void deleteItem(Integer id);
}
