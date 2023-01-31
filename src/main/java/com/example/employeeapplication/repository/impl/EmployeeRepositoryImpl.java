package com.example.employeeapplication.repository.impl;

import com.example.employeeapplication.pojo.entity.Employee;
import com.example.employeeapplication.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<String, Employee> map = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        map.put("1", new Employee("1", "Tom", new Date(), true));
        map.put("2", new Employee("2", "Jerry", new Date(), false));
    }

    @Override
    public Employee findById(String id) {
        return map.get(id);
    }

    @Override
    public Collection<Employee> findAll() {
        return map.values();
    }
}
