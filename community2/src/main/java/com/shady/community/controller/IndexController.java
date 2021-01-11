package com.shady.community.controller;

import com.shady.community.controller.mapper.UserMapper;
import com.shady.community.controller.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/index")
    public String index(HttpServletRequest httpServletRequest){
        Cookie[] cookies = httpServletRequest.getCookies();
        System.out.println("cookies长度是:"+cookies.length);
        for(Cookie cookie:cookies){
            System.out.println("获取的cookie名称是："+cookie.getName());
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                System.out.println("获取request中的token是："+cookie.getValue());
                User user = userMapper.findByToken(token);
                System.out.println("数据库获取到的用户token为："+user.getToken());
                if(user != null){
                    // 登录成功 写cookies session
                    httpServletRequest.getSession().setAttribute("user",user);
                    System.out.println("登录成功,当前登录用户token为："+user.getToken());
                }
                break;
            }
        }
        return "communityIndex";
    }
}
