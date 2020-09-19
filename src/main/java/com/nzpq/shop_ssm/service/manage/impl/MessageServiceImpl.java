package com.nzpq.shop_ssm.service.manage.impl;

import com.nzpq.shop_ssm.mapper.manage.MessageMapper;
import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.manage.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询所有留言，封装每条留言对应的用户对象
     * @return
     */
    @Override
    public List<Message> findAll() {
        List<Message> list = messageMapper.findAll();
        for(Message message : list ){
            User user = messageMapper.findUserById(message.getUser_id());
            message.setUser(user);
        }
        return list;
    }

    /**
     * 删除留言
     * @param id
     */
    @Override
    public void deleteMsg(Integer id) {
        messageMapper.delete(id);
    }
}
