package com.nzpq.shop_ssm.service.manage;

import com.nzpq.shop_ssm.pojo.Manage;
import com.nzpq.shop_ssm.pojo.User;

import java.util.List;

public interface AdminService {


    Manage login(Manage manage);

    List<User> findAllUser(Integer page, Integer size,User user);
}
