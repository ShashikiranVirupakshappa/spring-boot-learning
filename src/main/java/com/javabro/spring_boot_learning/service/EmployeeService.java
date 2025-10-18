package com.javabro.spring_boot_learning.service;

import com.javabro.spring_boot_learning.dto.EmployeeDTO;
import com.javabro.spring_boot_learning.model.Department;
import com.javabro.spring_boot_learning.model.Employee;
import com.javabro.spring_boot_learning.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public EmployeeDTO save(EmployeeDTO employee) {
        Employee employee1 = new Employee();
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setAge(employee.getAge());
        employee1.setSalary(employee.getSalary());
        Department department = new Department();
        department.setId(employee.getDepartmentDTO().getId());
        employee1.setDepartment(department);
        employee1 = employeeRepository.save(employee1);
        employee.setId(employee1.getId());
        return employee;
    }
}
