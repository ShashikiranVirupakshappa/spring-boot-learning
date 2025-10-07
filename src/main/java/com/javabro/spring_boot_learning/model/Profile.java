package com.javabro.spring_boot_learning.model;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String profileName;
    @OneToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

}
