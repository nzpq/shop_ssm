package com.nzpq.shop_ssm.service.manage.impl;

import com.github.pagehelper.PageHelper;
import com.nzpq.shop_ssm.mapper.manage.AdminMapper;
import com.nzpq.shop_ssm.pojo.Manage;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.manage.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    public Manage login(Manage manage){
        Manage manageDB = adminMapper.findByUsername(manage.getUsername());
        if(Objects.isNull(manageDB)){
            throw new RuntimeException("用户名不存在");
        }else{
            //用户名存在，比较密码
            if(manageDB.getPassword().equals(manage.getPassword())){
                //密码正确
                return manageDB;
            }else{
                throw new RuntimeException("密码错误");
            }
        }
    }

    @Override
    public List<User> findAllUser(Integer page, Integer size,User user) {
        PageHelper.startPage(page,size);
        return adminMapper.findAllUser(user);
    }

}
