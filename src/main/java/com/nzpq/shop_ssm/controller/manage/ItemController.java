package com.nzpq.shop_ssm.controller.manage;

import com.github.pagehelper.PageInfo;
import com.nzpq.shop_ssm.pojo.Item;
import com.nzpq.shop_ssm.pojo.ItemCategory;
import com.nzpq.shop_ssm.service.manage.ItemCategoryService;
import com.nzpq.shop_ssm.service.manage.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCategoryService itemCategoryService;
    //日志
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 查询所有商品信息
     * @param page
     * @param size
     * @param item
     * @param model
     * @return
     */
    @RequestMapping("/findAllItem")
    public String findAllItem(@RequestParam(name="page",defaultValue = "1") Integer page,
                              @RequestParam(name = "size",defaultValue = "8") Integer size,
                              Item item, Model model){
        logger.info(item);
        List<Item> list = itemService.findAllItem(page,size,item);
        PageInfo<Item> info = new PageInfo<>(list);
        model.addAttribute("info",info);
        return "manage/item";
    }

    /**
     * 携带分类信息跳转到添加商品页
     * @param model
     * @return
     */
    @RequestMapping("/toAddItem")
    public String toAddItem(Model model){
        //查询分类信息，跳转到商品添加页面
        List<ItemCategory> list = itemCategoryService.findAll2Level();
//        logger.info(list);
        model.addAttribute("list",list);
        return "manage/addItem";
    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping("/addItem")
    public String addItem(Item item, MultipartFile[] files) throws IOException {

        itemService.addItem(item,files);
        return "redirect:findAllItem";
    }

    /**
     * 下架商品
     * @return
     */
    @RequestMapping("/deleteItem")
    public String deleteItem(Integer id){
        itemService.deleteItem(id);
        return "redirect:findAllItem";
    }

    @RequestMapping("/test")
    public void test(){
        int i = 10 / 0;
        System.out.println(i);

    }
}
