package com.study.springboot.dao;

import com.study.springboot.entities.Department;
import com.study.springboot.entities.User;
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
public class DepartmentDao {
    private static final Map<Integer, Department> departments;

    static {
        departments = new HashMap<Integer, Department>();
        departments.put(1, new Department(1, "Technical"));
        departments.put(2, new Department(2, "Purchasing"));
        departments.put(3, new Department(3, "Administrative"));
    }

    private static Integer initId = 4;

    //添加用户
    public void save(@NotNull Department department) {
        if (department.getId() == null) {
            department.setId(initId);
        }
        departments.put(department.getId(), department);
    }

    //获取所有的用户
    public Collection<Department> getAll() {
        return departments.values();
    }

    //查询用户
    public Department get(Integer id) {
        return departments.get(id);
    }

    public void delete(Integer id) {
        departments.remove(id);
    }

}
