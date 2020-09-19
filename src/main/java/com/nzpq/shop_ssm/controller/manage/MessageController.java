package com.nzpq.shop_ssm.controller.manage;

import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.service.manage.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    /**
     * 查看所有留言
     * @return
     */
    @RequestMapping("/findAllMessage")
    public String findAllMessage(Model model){
        List<Message> list = messageService.findAll();
        model.addAttribute("list",list);
        return "manage/message";
    }

    @RequestMapping("/deleteMessage")
    public String deleteMsg(Integer id){
        messageService.deleteMsg(id);
        return "redirect:findAllMessage";
    }
}
