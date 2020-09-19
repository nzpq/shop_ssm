package com.nzpq.shop_ssm.mapper.manage;

import com.nzpq.shop_ssm.pojo.Manage;
import com.nzpq.shop_ssm.pojo.User;

import java.util.List;

public interface AdminMapper {
    /**
     * 登录
     * @return
     */
    Manage findByUsername(String username);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findAllUser(User user);
}
