package com.nzpq.shop_ssm.controller.manage;

import com.github.pagehelper.PageInfo;
import com.nzpq.shop_ssm.pojo.Manage;
import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.manage.AdminService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    //日志
    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login(Manage manage, Map<String,Object> map, HttpSession session){

//        logger.info("管理员登陆信息 --> "+manage);

        try {
            Manage manageDB = adminService.login(manage);
            //存储登陆成功后的用户信息
            session.setAttribute("admin",manageDB);
            return "manage/main";
        } catch (Exception e) {
            map.put("msg",e.getMessage());
           logger.error(e.toString());
           return "manage/login";
        }

    }

    /**
     * 查询所有用户信息，分页展示
     * @return
     */
    @RequestMapping("/findAllUser")
    public String findAllUser(@RequestParam(name="page",defaultValue = "1") Integer page,
                              @RequestParam(name = "size",defaultValue = "8") Integer size,
                              User user,Model model){
        logger.info("***************------->"+user);
        List<User> list =  adminService.findAllUser(page,size,user);
        PageInfo<User> info = new PageInfo<>(list);
        model.addAttribute("info",info);

        return "manage/user";
    }
}
