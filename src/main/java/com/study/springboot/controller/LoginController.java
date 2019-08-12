package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Alfie
 * @date 2019/8/12 0012 21:36
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        Map<String,Object> map) {
        if (StringUtils.isEmpty(email) && "123456".equals(password)) {
            //登入成功
            return "dashboard";
        } else {
            //登入失败
            map.put("msg","邮箱或者密码不正确");
            return "login";
        }
    }
}
