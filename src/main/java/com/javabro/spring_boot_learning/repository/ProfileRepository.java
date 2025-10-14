package com.javabro.spring_boot_learning.repository;

import com.javabro.spring_boot_learning.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
