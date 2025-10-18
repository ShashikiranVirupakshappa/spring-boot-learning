package com.javabro.spring_boot_learning.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentDesc;
    @OneToMany(mappedBy = "department",fetch = FetchType.LAZY)
    private Set<Employee> employees;
}
