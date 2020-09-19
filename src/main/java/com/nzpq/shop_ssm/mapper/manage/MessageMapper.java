package com.nzpq.shop_ssm.mapper.manage;

import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.pojo.User;

import java.util.List;

public interface MessageMapper {
    /**
     * 查询所有留言
     * @return
     */
    List<Message> findAll();

    /**
     * 查询每条留言对应的用户信息
     * @param user_id
     * @return
     */
    User findUserById(Integer user_id);

    /**
     * 删除一条留言
     * @param id
     */
    void delete(Integer id);
}
