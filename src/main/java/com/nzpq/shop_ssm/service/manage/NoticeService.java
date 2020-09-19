package com.nzpq.shop_ssm.service.manage;

import com.nzpq.shop_ssm.pojo.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> findAllNotice();

    void addNotice(Notice notice);

    Notice findOne(Integer id);

    void updateNotice(Notice notice);

    void delete(Integer id);
}
