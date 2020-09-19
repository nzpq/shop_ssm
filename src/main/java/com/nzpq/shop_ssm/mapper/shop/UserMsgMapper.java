package com.nzpq.shop_ssm.mapper.shop;

import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.pojo.Notice;
import com.nzpq.shop_ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMsgMapper {

    List<Notice> findAllNotice(@Param("noticeId") Integer noticeId);

    User findMyMsg(Integer id);

    void addMessage(Message msg);

    void updateUserMsg(User user);

    User findOldPass(@Param("oldPass") String oldPass, @Param("uid") Integer uid);

    void updatePass(@Param("newPass") String newPass, @Param("uid") Integer uid);
}
