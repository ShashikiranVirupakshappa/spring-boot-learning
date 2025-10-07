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
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String studentName;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    private Set<Courses> courses;

}
