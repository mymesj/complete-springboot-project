package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author Alfie
 * @date 2019/8/12 0012 21:36
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpSession session) {
        if ( !StringUtils.isEmpty(email) && "123456".equals(password)) {
            //登入成功
            session.setAttribute("loginEmail", email);

            //为了防止表单重复提交,添加redirect
            return "redirect:/main.html";
        } else {
            //登入失败
            map.put("msg","邮箱或者密码不正确");
            return "login";
        }
    }
}
