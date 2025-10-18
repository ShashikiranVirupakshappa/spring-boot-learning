package com.javabro.spring_boot_learning.service;

import com.javabro.spring_boot_learning.dto.ProfileDTO;
import com.javabro.spring_boot_learning.model.Profile;
import com.javabro.spring_boot_learning.model.User;
import com.javabro.spring_boot_learning.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @CachePut(cacheNames = "profiles", key = "#result.id")
    public ProfileDTO save(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setProfileName(profileDTO.getProfileName());
        User user = new User();
        user.setId(profileDTO.getUserId());
        profile.setUser(user);
        profile = profileRepository.save(profile);
        profileDTO.setId(profile.getId());
        return profileDTO;
    }
}
