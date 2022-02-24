package com.lessons.department.repository;

import com.lessons.department.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository  extends JpaRepository<Department, Integer>{
    
}
