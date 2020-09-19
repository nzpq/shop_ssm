package com.nzpq.shop_ssm.service.shop.impl;

import com.nzpq.shop_ssm.mapper.shop.ViewMapper;
import com.nzpq.shop_ssm.pojo.Item;
import com.nzpq.shop_ssm.service.shop.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViewServiceImpl implements ViewService {

    @Autowired
    private ViewMapper viewMapper;

    /**
     * 查询折扣商品
     * @return
     */
    @Override
    public List<Item> findZheKouItem() {
        return viewMapper.findZheKouItem();
    }

    /**
     * 查询热门商品
     * @return
     */
    @Override
    public List<Item> findReMenItem() {
        return viewMapper.findReMenItem();
    }
}
