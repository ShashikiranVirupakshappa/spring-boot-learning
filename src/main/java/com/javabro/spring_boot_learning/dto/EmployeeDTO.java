package com.javabro.spring_boot_learning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Double salary;
    private DepartmentDTO departmentDTO;
}
