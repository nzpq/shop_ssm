package com.nzpq.shop_ssm.service.shop;

import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.pojo.Notice;
import com.nzpq.shop_ssm.pojo.User;

import java.util.List;

public interface UserMsgService {
    List<Notice> findAllNotice(Integer noticeId);

    User findMyMsg(Integer id);

    void addMessage(Message msg);

    void updateUserMsg(User user);

    void updatePass(String oldPass, String newPass,Integer uid);
}
