package com.nzpq.shop_ssm.service.manage;

import com.nzpq.shop_ssm.pojo.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    void deleteMsg(Integer id);
}
