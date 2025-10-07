package com.javabro.spring_boot_learning.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentDesc;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
