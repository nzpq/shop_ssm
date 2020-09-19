package com.nzpq.shop_ssm.controller.manage;

import com.nzpq.shop_ssm.pojo.Notice;
import com.nzpq.shop_ssm.service.manage.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询所有公告
     * @param model
     * @return
     */
    @RequestMapping("/findAllNotice")
    public String findAllNotice(Model model){
        List<Notice> list = noticeService.findAllNotice();
        model.addAttribute("list",list);
        return "manage/notice";
    }

    /**
     * 完成添加公告
     * @param notice
     * @return
     */
    @RequestMapping("/addNotice")
    public String addNotice(Notice notice){
        noticeService.addNotice(notice);
        return "redirect:findAllNotice";
    }

    /**
     * 查询一个，用户修改时数据回显
     * @return
     */
    @RequestMapping("/findOne")
    public String findOne(Integer id,Model model){
        Notice notice = noticeService.findOne(id);
        model.addAttribute("notice",notice);
        return "manage/updateNotice";
    }

    /**
     * 完成更新
     * @param notice
     * @return
     */
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice notice){
        noticeService.updateNotice(notice);
        return "redirect:findAllNotice";
    }

    /**
     * 删除公告
     * @return
     */
    @RequestMapping("/deleteNotice")
    public String deleteNotice(Integer id){
        noticeService.delete(id);
        return "redirect:findAllNotice";
    }
}
