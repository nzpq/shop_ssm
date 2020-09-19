package com.nzpq.shop_ssm.controller.shop;

import com.nzpq.shop_ssm.domain.Category;
import com.nzpq.shop_ssm.pojo.Item;
import com.nzpq.shop_ssm.pojo.ItemCategory;
import com.nzpq.shop_ssm.service.manage.ItemCategoryService;
import com.nzpq.shop_ssm.service.shop.ViewService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ViewController {

    @Autowired
    private ItemCategoryService itemCategoryService;
    @Autowired
    private ViewService viewService;

    //日志
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/")
    public String findCategory(Model model){
        /*
            查询分类信息
         */
        //封装Category
        List<Category> list = new ArrayList<>();
        List<ItemCategory> parentList = itemCategoryService.findAll(null, null);//查询出的所有一级分类
        for(ItemCategory itemCategory : parentList){

            List<ItemCategory> childrensList = itemCategoryService.findAll2Level(null, null, itemCategory.getId());//查询出一级分类下对应的所有二级分类
            //封装数据
            Category category = new Category();
            category.setParent(itemCategory);
            category.setChildrens(childrensList);
            list.add(category);
        }
        model.addAttribute("list",list);
        /*
            查询折扣商品
         */
        List<Item> zkList = viewService.findZheKouItem();
        model.addAttribute("zkList",zkList);
        /*
            查询热门商品
         */
        List<Item> rmList = viewService.findReMenItem();
        model.addAttribute("rmList",rmList);
        return "shop/index";
    }
}
