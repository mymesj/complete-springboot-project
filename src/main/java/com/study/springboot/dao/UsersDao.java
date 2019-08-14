package com.study.springboot.dao;

import com.study.springboot.entities.Department;
import com.study.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alfie
 * @date 2019/8/14 11:03
 */
@Component
public class UsersDao {

    @Autowired
    private DepartmentDao departmentDao;
    private static final Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>();
        users.put(1001, new User(1001, "U-AA", "aa@qq.com", 1, new Department(1, "Technical"), new Date()));
        users.put(1002, new User(1002, "U-BB", "bb@qq.com", 1, new Department(1, "Technical"), new Date()));
        users.put(1003, new User(1003, "U-CC", "cc@qq.com", 0, new Department(2, "Purchasing"), new Date()));
        users.put(1004, new User(1004, "U-DD", "dd@qq.com", 0, new Department(3, "Administrative"), new Date()));
        users.put(1005, new User(1005, "U-EE", "ee@qq.com", 1, new Department(3, "Administrative"), new Date()));
        users.put(1006, new User(1006, "U-FF", "ff@qq.com", 1, new Department(3, "Technical"), new Date()));
    }

    private static Integer initId = 1007;

    //添加用户
    public void save(@NotNull User user) {
        if (user.getId() == null) {
            user.setId(initId);
        }
        user.setDepartment(departmentDao.get(user.getDepartment().getId()));
        users.put(user.getId(), user);
    }

    //获取所有的用户
    public Collection<User> getAll() {
        return users.values();
    }

    //查询用户
    public User get(Integer id) {
        return users.get(id);
    }

    public void delete(Integer id) {
        users.remove(id);
    }
}
