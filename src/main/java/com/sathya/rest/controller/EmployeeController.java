package com.sathya.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rest.entity.EmployeeEntity;
import com.sathya.rest.model.EmployeeModel;
import com.sathya.rest.service.EmployeeService;
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    
    @Autowired
    EmployeeService employeeService;
    
    @PostMapping("/saveemployee")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeModel employeeModel) {
        
        EmployeeEntity employeeEntity = employeeService.saveemployee(employeeModel);
        return employeeEntity;
    }
}

