package com.javabro.spring_boot_learning.service;

import com.javabro.spring_boot_learning.dto.DepartmentDTO;
import com.javabro.spring_boot_learning.model.Department;
import com.javabro.spring_boot_learning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @CachePut(cacheNames = "departments", key = "#result.id")
    public DepartmentDTO save(DepartmentDTO department) {
        Department department1 = new Department();
        department1.setDepartmentCode(department.getDepartmentCode());
        department1.setDepartmentName(department.getDepartmentName());
        department1.setDepartmentDesc(department.getDepartmentDesc());
        department1 = departmentRepository.save(department1);
        department.setId(department1.getId());
        return department;
    }
}
