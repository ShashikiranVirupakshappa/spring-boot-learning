package com.javabro.spring_boot_learning.repository;

import com.javabro.spring_boot_learning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
