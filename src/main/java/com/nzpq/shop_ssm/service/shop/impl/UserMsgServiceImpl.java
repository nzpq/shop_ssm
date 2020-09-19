package com.nzpq.shop_ssm.service.shop.impl;

import com.nzpq.shop_ssm.mapper.shop.UserMsgMapper;
import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.pojo.Notice;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.shop.UserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserMsgServiceImpl implements UserMsgService {

    @Autowired
    private UserMsgMapper userMsgMapper;

    /**
     * 查询公告列表，以及详细信息
     * @param noticeId
     * @return
     */
    @Override
    public List<Notice> findAllNotice(Integer noticeId) {
        return userMsgMapper.findAllNotice(noticeId);
    }

    @Override
    public User findMyMsg(Integer id) {
        return userMsgMapper.findMyMsg(id);
    }

    @Override
    public void addMessage(Message msg) {
        userMsgMapper.addMessage(msg);
    }

    @Override
    public void updateUserMsg(User user) {
        userMsgMapper.updateUserMsg(user);
    }

    @Override
    public void updatePass(String oldPass, String newPass,Integer uid) {
        User user = userMsgMapper.findOldPass(oldPass,uid);
        if(user == null){
            throw new RuntimeException("原始密码错误");
        }else{
            userMsgMapper.updatePass(newPass,uid);
        }
    }
}
