package com.sathya.rest.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.rest.entity.EmployeeEntity;
import com.sathya.rest.model.EmployeeModel;
import com.sathya.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

public  EmployeeEntity saveemployee (EmployeeModel model) {
EmployeeEntity employeeEntity = new EmployeeEntity();
        
        // Copy basic properties
        employeeEntity.setEmpName(model.getEmpName());
        employeeEntity.setBasicSalary(model.getBasicSalary());
        employeeEntity.setEmpDept(model.getEmpDept());
        employeeEntity.setEmpEmail(model.getEmpEmail());
        employeeEntity.setEmpMobile(model.getEmpMobile());
        
        // Calculate salary components
        double basicSalary = model.getBasicSalary();
        
        // Example calculations
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        double pf = basicSalary * 0.12;
        double totalSalary = basicSalary + hra + da - pf;
        
        // Set calculated fields in EmployeeEntity
        employeeEntity.setHra(hra);
        employeeEntity.setDa(da);
        employeeEntity.setPf(pf);
        employeeEntity.setTotalSalary(totalSalary);
        
        // Set other entity-specific fields like joining date
        employeeEntity.setJoiningDate(LocalDate.now()); 
        
        return employeeRepository.save(employeeEntity);

	}

}

