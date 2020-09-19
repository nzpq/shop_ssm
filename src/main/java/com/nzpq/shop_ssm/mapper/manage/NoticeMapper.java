package com.nzpq.shop_ssm.mapper.manage;

import com.nzpq.shop_ssm.pojo.Notice;

import java.util.List;

public interface NoticeMapper {
    /**
     * 查询所有公告
     * @return
     */
    List<Notice> findAllNotice();

    /**
     * 添加
     * @param notice
     */
    void addNotice(Notice notice);

    /**
     * 查询一个
     * @param id
     * @return
     */
    Notice findOne(Integer id);

    /**
     * 修改
     * @param notice
     */
    void updateNotice(Notice notice);

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);
}
