package com.javabro.spring_boot_learning.controller;

import com.javabro.spring_boot_learning.model.Department;
import com.javabro.spring_boot_learning.model.Employee;
import com.javabro.spring_boot_learning.model.Profile;
import com.javabro.spring_boot_learning.model.User;
import com.javabro.spring_boot_learning.repository.DepartmentRepository;
import com.javabro.spring_boot_learning.repository.EmployeeRepository;
import com.javabro.spring_boot_learning.repository.ProfileRepository;
import com.javabro.spring_boot_learning.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("profile")
    public Profile createProfile(@RequestBody Profile profile) {
        return profileRepository.save(profile);
    }

    @PostMapping("department")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PostMapping("employeev2")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
}