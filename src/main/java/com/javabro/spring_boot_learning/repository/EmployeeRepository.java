package com.javabro.spring_boot_learning.repository;

import com.javabro.spring_boot_learning.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
