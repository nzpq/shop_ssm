package com.nzpq.shop_ssm.service.manage;

import com.nzpq.shop_ssm.pojo.ItemCategory;

import java.util.List;

public interface ItemCategoryService {

    List<ItemCategory> findAll(Integer page,Integer size);

    List<ItemCategory> findAll2Level(Integer page, Integer size,Integer id);

    void addItemCategory(ItemCategory itemCategory);

    ItemCategory findOneItemCategory(Integer id);

    void updateItemCategory(ItemCategory itemCategory);

    void deleteItemCategory(Integer id);

    List<ItemCategory> findAll2Level();
}
