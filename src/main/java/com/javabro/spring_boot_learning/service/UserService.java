package com.javabro.spring_boot_learning.service;

import com.javabro.spring_boot_learning.dto.UserDTO;
import com.javabro.spring_boot_learning.model.User;
import com.javabro.spring_boot_learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Cacheable(cacheNames = "users", key = "#id")
    public UserDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        UserDTO userDTO = null;
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setUserName(user.getUserName());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setLastName(user.getLastName());
        }
        return userDTO;
    }

    @CachePut(cacheNames = "users", key = "#result.id")
    public UserDTO save(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user = userRepository.save(user);
        userDTO.setId(user.getId());
        return userDTO;
    }
}
