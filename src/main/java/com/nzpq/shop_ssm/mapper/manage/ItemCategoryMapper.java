package com.nzpq.shop_ssm.mapper.manage;

import com.nzpq.shop_ssm.pojo.ItemCategory;

import java.util.List;

public interface ItemCategoryMapper {
    /**
     * 查询所有一级分类
     * @return
     */
    List<ItemCategory> findAll();

    /**
     * 查询一级分类下的二级分类
     * @return
     */
    List<ItemCategory> findAll2Level(Integer id);

    /**
     * 添加一级分类或者二级分类
     * @param itemCategory
     */
    void addItemCategory(ItemCategory itemCategory);

    /**
     * 查询一个一级分类或者二级分类
     * @param id
     * @return
     */
    ItemCategory findOneItemCategory(Integer id);

    /**
     * 修改一级分类或二级分类
     * @param itemCategory
     */
    void updateItemCategory(ItemCategory itemCategory);

    /**
     * 删除一级分类或二级分类，其实是假删除，只需把isDelete变为1即可
     * @param id
     */
    void deleteItemCategory(Integer id);

    /**
     * 查询所有二级分类
     * @return
     */
    List<ItemCategory> findAll2_Level();
}
