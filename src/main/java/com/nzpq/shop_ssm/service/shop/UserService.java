package com.nzpq.shop_ssm.service.shop;

import com.nzpq.shop_ssm.pojo.User;

public interface UserService {
    void register(User user);

    User login(User user);
}
