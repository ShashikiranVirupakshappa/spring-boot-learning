package com.javabro.spring_boot_learning.service;

import com.javabro.spring_boot_learning.dto.DepartmentDTO;
import com.javabro.spring_boot_learning.model.Department;
import com.javabro.spring_boot_learning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public DepartmentDTO getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(() -> new RuntimeException("Department not found for code: "+departmentCode));
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setDepartmentCode(department.getDepartmentCode());
        departmentDTO.setDepartmentName(department.getDepartmentName());
        departmentDTO.setDepartmentDesc(department.getDepartmentDesc());
        departmentDTO.setId(department.getId());
        return departmentDTO;
    }
}
