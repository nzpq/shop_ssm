package com.nzpq.shop_ssm.controller.manage;

import com.github.pagehelper.PageInfo;
import com.nzpq.shop_ssm.pojo.ItemCategory;
import com.nzpq.shop_ssm.service.manage.ItemCategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    //日志
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 查询所有一级分类
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAllItemCategory1Level(@RequestParam(name="page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "size",defaultValue = "5") Integer size, Model model){

        List<ItemCategory> list = itemCategoryService.findAll(page, size);
        PageInfo<ItemCategory> info = new PageInfo<>(list);
        model.addAttribute("info",info);
        return "manage/itemCategory";
    }

    /**
     * 查询所有二级分类
     * @param page 页码
     * @param size 每页显示条目数
     * @param model
     * @return
     */
    @RequestMapping("/findAll2Level")
    public String findAllItemCategory2Level(@RequestParam(name="page",defaultValue = "1") Integer page,
                                      @RequestParam(name = "size",defaultValue = "5") Integer size,
                                            Integer id,Model model){
        List<ItemCategory> list = itemCategoryService.findAll2Level(page, size,id);
        PageInfo<ItemCategory> info = new PageInfo<>(list);
        model.addAttribute("info",info);
        /*
            这行代码的意思是：当进行新增二级分类时，需要父分类的id，这行代码就是将父id存到model中，携带到展示二级分类的页面，
            当执行新增操作时，就携带这个父id到后台
         */
        model.addAttribute("id",id);
        return "manage/itemCategory2";
    }

    /**
     * 添加一级分类,或二级分类
     * @param itemCategory
     * @return
     */
    @RequestMapping("/addItemCategory")
    public String addItemCategory1Level(ItemCategory itemCategory){
        logger.info("======"+itemCategory);
        itemCategoryService.addItemCategory(itemCategory);
        //重定向到查询所有一级分类
        return "redirect:findAll";
    }

    /**
     * 查询一个一级分类或二级分类，用于修改时回显数据
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findOneItemCategory")
    public String findOne(@RequestParam(name = "id") Integer id,Model model){
        ItemCategory itemCategory = itemCategoryService.findOneItemCategory(id);
        model.addAttribute("item",itemCategory);
        return "manage/update";
    }

    /**
     * 完成修改一级分类，或二级分类
     * @return
     */
    @RequestMapping("/updateItemCategory")
    public String updateItemCategory1Level(ItemCategory itemCategory){
        itemCategoryService.updateItemCategory(itemCategory);
        return "redirect:findAll";
    }

    /**
     * 删除一级分类或二级分类，删除一级分类的同时，会删除此一级分类下的所有二级分类
     * @param id
     * @return
     */
    @RequestMapping("/deleteItemCategory")
    public String delete1Level(@RequestParam(name = "id") Integer id){
        itemCategoryService.deleteItemCategory(id);
        return "redirect:findAll";
    }

    /**
     * 携带当前二级分类的父id，跳转到二级分类添加页面
     * @return
     */
    @RequestMapping("/toAddCategory2")
    public String toAdd2Level(Integer pid,Model model){

//        logger.info("========="+pid+"=================");
        model.addAttribute("pid",pid);
        return "manage/addCategory2";
    }
}
