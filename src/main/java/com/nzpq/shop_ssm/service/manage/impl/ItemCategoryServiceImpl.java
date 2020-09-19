package com.nzpq.shop_ssm.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.shop_ssm.mapper.manage.ItemCategoryMapper;
import com.nzpq.shop_ssm.pojo.ItemCategory;
import com.nzpq.shop_ssm.service.manage.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemCategoryServiceImpl implements ItemCategoryService {

    @Autowired
    private ItemCategoryMapper itemCategoryMapper;

    /**
     * 查询一级分类
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<ItemCategory> findAll(Integer page, Integer size) {
        //PageHelper pageNum:页码值，pageSize：每页显示条数
        if(page != null && size != null){
            PageHelper.startPage(page,size);
        }

        return itemCategoryMapper.findAll();

    }

    /**
     * 查询一级分类下对应的二级分类
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<ItemCategory> findAll2Level(Integer page, Integer size,Integer id) {
        if(page != null && size != null){
            PageHelper.startPage(page,size);
        }
        return itemCategoryMapper.findAll2Level(id);
    }

    /**
     * 添加一级分类或者二级分类
     * @param itemCategory
     */
    @Override
    public void addItemCategory(ItemCategory itemCategory) {
        //前台传来的数据只有name 封装 ItemCategory
        itemCategory.setIsDelete(0);
        itemCategoryMapper.addItemCategory(itemCategory);
    }

    /**
     * 查询一个一级分类或者二级分类，用于修改时，数据回显
     * @param id
     * @return
     */
    @Override
    public ItemCategory findOneItemCategory(Integer id) {
        return itemCategoryMapper.findOneItemCategory(id);
    }

    /**
     * 更新一级分类
     * @param itemCategory
     */
    @Override
    public void updateItemCategory(ItemCategory itemCategory) {
        itemCategoryMapper.updateItemCategory(itemCategory);
    }

    /**
     * 删除一级分类
     * @param id
     */
    @Override
    public void deleteItemCategory(Integer id) {
        itemCategoryMapper.deleteItemCategory(id);
    }

    /**
     * 查询所有二级分类，用于添加商品是回显
     * @return
     */
    @Override
    public List<ItemCategory> findAll2Level() {
        return itemCategoryMapper.findAll2_Level();
    }


}
