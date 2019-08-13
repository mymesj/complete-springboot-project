package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Alfie
 * @date 2019/8/13 15:12
 */
@Controller
public class UsersController {

    @RequestMapping("/users")
    public String users(){
        return "/users/list";
    }
}
