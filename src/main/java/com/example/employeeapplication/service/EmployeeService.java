package com.example.employeeapplication.service;

import com.example.employeeapplication.pojo.dto.EmployeeResponseDTO;
import com.example.employeeapplication.pojo.dto.EmployeeResponseDTO.*;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    EmployeeResponseDTO getAllEmp();
    EmployeeDTO getEmpById(String id);
}
