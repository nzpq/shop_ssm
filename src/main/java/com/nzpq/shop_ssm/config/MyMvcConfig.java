package com.nzpq.shop_ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {



    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //视图映射
                //浏览器发送 /manage ，进入到后代管理登录页面
                registry.addViewController("/manage").setViewName("manage/login");
                registry.addViewController("/addCategory").setViewName("manage/addCategory");//添加一级分类页
                registry.addViewController("/addNotice").setViewName("manage/addNotice");//添加公告页
                registry.addViewController("/login").setViewName("shop/login");//跳转到用户登录页
                registry.addViewController("/register").setViewName("shop/register");//跳转到用户注册页
                registry.addViewController("/toUpdatePass").setViewName("shop/updatePassword");//跳转到用户注册页

            }

        };
        return configurer;
    }
}
