package com.example.employeeapplication.repository;

import com.example.employeeapplication.pojo.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository {
    Employee findById(String id);
    Collection<Employee> findAll();
}
