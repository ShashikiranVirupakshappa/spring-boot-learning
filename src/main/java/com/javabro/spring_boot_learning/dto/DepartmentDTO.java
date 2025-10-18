package com.javabro.spring_boot_learning.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements Serializable {
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentDesc;
}
