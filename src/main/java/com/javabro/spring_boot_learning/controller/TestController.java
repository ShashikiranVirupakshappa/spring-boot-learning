package com.javabro.spring_boot_learning.controller;

import com.javabro.spring_boot_learning.dto.DepartmentDTO;
import com.javabro.spring_boot_learning.dto.EmployeeDTO;
import com.javabro.spring_boot_learning.dto.ProfileDTO;
import com.javabro.spring_boot_learning.dto.UserDTO;
import com.javabro.spring_boot_learning.model.Department;
import com.javabro.spring_boot_learning.model.Employee;
import com.javabro.spring_boot_learning.model.Profile;
import com.javabro.spring_boot_learning.model.User;
import com.javabro.spring_boot_learning.repository.DepartmentRepository;
import com.javabro.spring_boot_learning.repository.EmployeeRepository;
import com.javabro.spring_boot_learning.repository.ProfileRepository;
import com.javabro.spring_boot_learning.repository.UserRepository;
import com.javabro.spring_boot_learning.service.DepartmentService;
import com.javabro.spring_boot_learning.service.EmployeeService;
import com.javabro.spring_boot_learning.service.ProfileService;
import com.javabro.spring_boot_learning.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    ProfileService profileService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    UserService userService;

    @PostMapping("user")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PostMapping("profile")
    public ProfileDTO createProfile(@RequestBody ProfileDTO profileDTO) {
        return profileService.save(profileDTO);
    }

    @PostMapping("department")
    public DepartmentDTO createDepartment(@RequestBody DepartmentDTO department) {
        return departmentService.save(department);
    }

    @PostMapping("employeev2")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) {
        return employeeService.save(employee);
    }

    @GetMapping("user/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}