package com.nzpq.shop_ssm.service.shop.impl;

import com.nzpq.shop_ssm.mapper.shop.UserMapper;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.shop.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     */
    @Override
    public void register(User user) {
            User u = userMapper.findByUsername(user.getUsername());
            if(u == null){
                //执行注册
                userMapper.register(user);
            }else{
                //用户名已存在
                throw new RuntimeException("用户名已存在！");
            }
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public User login(User user) {

        User userDB = userMapper.findByUsername(user.getUsername());
        if(userDB == null){
            //用户名错误
            throw new RuntimeException("用户名错误！");
        }else{
            //比较密码
            if(userDB.getPassword().equals(user.getPassword())){
                //密码正确
                return userDB;
            }else{
                //密码错误
                throw new RuntimeException("密码错误！");
            }
        }
    }
}
