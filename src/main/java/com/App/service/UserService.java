package com.App.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.App.entity.User;
import com.App.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    //@Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}