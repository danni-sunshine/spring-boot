package com.ziwei.springboot.controller;

import com.ziwei.springboot.dao.DepartmentDao;
import com.ziwei.springboot.dao.EmployeeDao;
import com.ziwei.springboot.entities.Department;
import com.ziwei.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmpsController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //跳转到员工列表界面
    @GetMapping(value = "emps")
    public String getList(Model model){
        Collection<Employee> all = employeeDao.getAll();
        //model.addAttribute("emps",all);
        return "emp/list";
    }

    @GetMapping(value = "emp")
    public String addEmps(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    /*@PostMapping(value = "emp")
    public String addSubmit(){

    }*/
}
