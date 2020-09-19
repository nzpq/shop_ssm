package com.nzpq.shop_ssm.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.shop_ssm.mapper.manage.ItemCategoryMapper;
import com.nzpq.shop_ssm.mapper.manage.ItemMapper;
import com.nzpq.shop_ssm.pojo.Item;
import com.nzpq.shop_ssm.service.manage.ItemService;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ItemCategoryMapper itemCategoryMapper;
    //日志
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 查询所有商品信息
     * @param page
     * @param size
     * @param item
     * @return
     */
    @Override
    public List<Item> findAllItem(Integer page, Integer size, Item item) {
        PageHelper.startPage(page,size);
        List<Item> list = itemMapper.findAllItem(item);
        for(Item item1 : list){
            //封装所属分类
            item1.setCategory1Level(itemCategoryMapper.findOneItemCategory(item1.getCategory_id_one()));//封装一级分类信息;
            item1.setCategory2Level(itemCategoryMapper.findOneItemCategory(item1.getCategory_id_two()));//封装二级分类信息;
        }
        return list;
    }

    /**
     * 添加商品
     * @param item
     * @param files
     */
    @Override
    public void addItem(Item item, MultipartFile[] files) {
        //上传图片文件夹路径
        String realPath = "D:\\IdeaProjects\\shop_ssm\\src\\main\\webapp\\static\\upload";
        //存储图片路径
        StringBuilder sb = new StringBuilder();

        for (MultipartFile file : files) {
            if (!StringUtils.isEmpty(file.getOriginalFilename())) {
                //保存图片
                //FilenameUtils.getExtension( ) 获取文件扩展名
                String newFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
//                file.transferTo(new File(realPath, newFileName));
//                logger.info(newFileName);
                sb.append(newFileName + "_");
            }

        }
        String[] s = sb.toString().split("_");
        logger.info(sb.toString());
        logger.info((s.length == 0)+"==="+ Arrays.toString(s));
    }

    /**
     * 下架商品
     * @param id
     */
    @Override
    public void deleteItem(Integer id) {
        itemMapper.deleteItem(id);
    }
}
