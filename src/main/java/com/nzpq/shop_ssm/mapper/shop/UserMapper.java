package com.nzpq.shop_ssm.mapper.shop;

import com.nzpq.shop_ssm.pojo.User;

public interface UserMapper {
    /**
     * 根据username查找
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 完成注册
     * @param user
     */
    void register(User user);
}
