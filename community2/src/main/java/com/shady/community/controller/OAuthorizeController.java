package com.shady.community.controller;


import com.shady.community.controller.mapper.UserMapper;
import com.shady.community.controller.model.User;
import com.shady.community.dto.AccessTokenDto;
import com.shady.community.dto.GitHubUser;
import com.shady.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class OAuthorizeController {

    @Autowired
    private  GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.url}")
    private  String redirectUrl;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setCode(code);
        accessTokenDto.setRedirect_uri(redirectUrl);
        accessTokenDto.setState(state);
        String accessToken = gitHubProvider.getAccessToken(accessTokenDto);
        GitHubUser gitHubUser = gitHubProvider.getGitHubUser(accessToken);
        if(gitHubUser!=null){
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setAccount_id(token);
            user.setName(gitHubUser.getName());
            user.setToken(accessToken);
            user.setCreated_time(System.currentTimeMillis());
            user.setModified_time(System.currentTimeMillis());
            userMapper.insert(user);
            httpServletResponse.addCookie(new Cookie("token",token));
//            // 登录成功 写cookies session
//            httpServletRequest.getSession().setAttribute("user",gitHubUser);
            return "redirect:/index";
        }else{
            // 登录失败 重新登录
            return "redirect:/";
        }
    }
}
