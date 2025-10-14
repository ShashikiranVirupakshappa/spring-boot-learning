package com.javabro.spring_boot_learning.repository;


import com.javabro.spring_boot_learning.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
