package com.nzpq.shop_ssm.controller.shop;

import com.nzpq.shop_ssm.pojo.User;
import com.nzpq.shop_ssm.service.shop.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    //日志
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * 注册
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/register")
    public String register(User user, Model model){
        try {
            userService.register(user);
            model.addAttribute("username",user.getUsername());
            return "shop/login";
        } catch (Exception e) {
            logger.error(e.getMessage());
            model.addAttribute("error",e.getMessage());
            return "shop/register";
        }
    }

    /**
     * 登录
     * @param user
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/login")
    public String login(User user, Model model, HttpServletRequest request){
        try {
            User userDB = userService.login(user);
            request.getSession().setAttribute("user",userDB);
//            return "redirect:http://localhost:8080/shop/";
            return "redirect:/shop/";
        } catch (Exception e) {
            logger.error(e.getMessage());
            model.addAttribute("error",e.getMessage());
            return "shop/login";
        }
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "redirect:/shop/";
    }

}
