package com.nzpq.shop_ssm.mapper.shop;

import com.nzpq.shop_ssm.pojo.Item;

import java.util.List;

public interface ViewMapper {
    /**
     * 查询折扣商品
     * @return
     */
    List<Item> findZheKouItem();

    /**
     * 查询热门商品
     * @return
     */
    List<Item> findReMenItem();
}
