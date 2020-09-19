package com.nzpq.shop_ssm.controller.shop;

import com.nzpq.shop_ssm.pojo.Message;
import com.nzpq.shop_ssm.pojo.Notice;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.shop.UserMsgService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userMsg")
public class UserMsgController {

    @Autowired
    private UserMsgService userMsgService;
    //日志
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 查询公告列表
     * @param model
     * @return
     */
    @RequestMapping("/findNoticeList")
    public String findNoticeList(Model model){
        List<Notice> list = userMsgService.findAllNotice(null);
        model.addAttribute("list",list);
        return "shop/noticeList";
    }

    /**
     * 查看公告详情
     * @param model
     * @param noticeId
     * @return
     */
    @RequestMapping("/findNoticeDetail")
    public String findNoticeDetail(Model model,Integer noticeId){
        List<Notice> list = userMsgService.findAllNotice(noticeId);
        model.addAttribute("info",list.get(0));
        logger.info(list);
        return "shop/noticeDetail";
    }

    /**
     * 用户进入个人中心，查询用户个人信息
     * @param model
     * @return
     */
    @RequestMapping("/myCenter")
    public String myCenter(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        User u = userMsgService.findMyMsg(user.getId());
        model.addAttribute("user",u);
        return "shop/myCenter";
    }

    /**
     * 跳转到用户添加留言页或者添加用户留言
     */
    @RequestMapping("/addMessage")
    public String addMessage( Message msg,HttpServletRequest request ){

        //完成添加留言
        User user = (User) request.getSession().getAttribute("user");
        msg.setUser_id(user.getId());
        userMsgService.addMessage(msg);
        return "shop/index";


    }

    /**
     * 跳转到用户添加留言页
     */
    @RequestMapping("/toAddMessage")
    public String toAddMessage(  ){
        return "shop/addMessage";
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @RequestMapping("/updateMsg")
    public String updateMsg(User user,HttpServletRequest request){
        User u = (User) request.getSession().getAttribute("user");
        user.setId(u.getId());
        userMsgService.updateUserMsg(user);
        return "redirect:/userMsg/myCenter";
    }

    /**
     * 修改密码
     * @param oldPass
     * @param newPass
     * @return
     */
    @RequestMapping("/updatePass")
    public String updatePass(@RequestParam("oldPass") String oldPass, @RequestParam("newPass") String newPass, Map<String,Object> map,HttpServletRequest request){
        try {
            User u = (User) request.getSession().getAttribute("user");
            userMsgService.updatePass(oldPass,newPass,u.getId());
            return "redirect:/login";
        } catch (Exception e) {
            map.put("msg",e.getMessage());
            return "/shop/updatePassword";
        }

    }

}
