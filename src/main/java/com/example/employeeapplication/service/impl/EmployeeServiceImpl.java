package com.example.employeeapplication.service.impl;

import com.example.employeeapplication.exception.ResourceNotFoundException;
import com.example.employeeapplication.pojo.dto.EmployeeResponseDTO;
import com.example.employeeapplication.pojo.dto.EmployeeResponseDTO.*;
import com.example.employeeapplication.pojo.entity.Employee;
import com.example.employeeapplication.repository.EmployeeRepository;
import com.example.employeeapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeResponseDTO getAllEmp() {
        Collection<Employee> employeeCollection = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOs = employeeCollection.stream().map(e -> new EmployeeDTO(e)).collect(Collectors.toList());
        return new EmployeeResponseDTO(employeeDTOs);
    }

    @Override
    public EmployeeDTO getEmpById(String id) {
        Employee employee = employeeRepository.findById(id);
        if (employee == null) {
            //log
            throw new ResourceNotFoundException("...");
        }
        return new EmployeeDTO(employee);

    }
}
