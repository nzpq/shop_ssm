package com.nzpq.shop_ssm.service.manage.impl;

import com.nzpq.shop_ssm.mapper.manage.NoticeMapper;
import com.nzpq.shop_ssm.pojo.Notice;
import com.nzpq.shop_ssm.service.manage.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 查询所有公告
     * @return
     */
    @Override
    public List<Notice> findAllNotice() {
        return noticeMapper.findAllNotice();
    }

    /**
     * 添加公告
     * @param notice
     */
    @Override
    public void addNotice(Notice notice) {
        //封装notice
        notice.setAddTime(new Date());
        noticeMapper.addNotice(notice);
    }

    /**
     * 查询一个，用于修改时回显数据
     * @param id
     * @return
     */
    @Override
    public Notice findOne(Integer id) {
        return noticeMapper.findOne(id);
    }

    /**
     * 完成更新
     * @param notice
     */
    @Override
    public void updateNotice(Notice notice) {
        notice.setAddTime(new Date());
        noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告
     * @param id
     */
    @Override
    public void delete(Integer id) {
        noticeMapper.delete(id);
    }
}
