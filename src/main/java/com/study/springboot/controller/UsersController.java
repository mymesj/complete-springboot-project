package com.study.springboot.controller;

import com.study.springboot.dao.DepartmentDao;
import com.study.springboot.dao.UsersDao;
import com.study.springboot.entities.Department;
import com.study.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Alfie
 * @date 2019/8/13 15:12
 */
@Controller
public class UsersController {

    @Autowired
    private UsersDao usersDao;
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/users")
    public String users(Model model) {
        Collection<User> users = usersDao.getAll();
        model.addAttribute("users", users);
        return "/users/list";
    }

    //去添加用户页面
    @GetMapping("/addUser")
    public String toAddUserPage(Model model) {
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);
        return "/users/add";
    }

    @PostMapping("/user")
    public String addUser(User user) {
        usersDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/user/{id}")
    public String toEditUserPage(@PathVariable("id") Integer id, Model model) {
        User user = usersDao.get(id);
        model.addAttribute("user", user);
        Collection<Department> departments = departmentDao.getAll();
        model.addAttribute("departments", departments);
        return "/users/add";
    }

    @PutMapping("/user")
    public String updateUser(User user) {
        usersDao.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        usersDao.delete(id);
        return "redirect:/users";
    }
}
