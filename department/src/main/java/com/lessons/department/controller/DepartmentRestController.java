package com.lessons.department.controller;

import java.util.List;

import com.lessons.department.entity.Department;
import com.lessons.department.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/greet") 
    public String greetMe() {
        return "Hello there";
    }

    @GetMapping("/")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @PostMapping("/addDepartment") 
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
    }

    @GetMapping("/deleteDepartment/{id}")
    public void deleteDepartment(@PathVariable("id") Integer id) {
        departmentService.deleteDepartment(id);
    }
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable("id") Integer id) {
        return departmentService.getDepartmentById(id);
    }

    
}
