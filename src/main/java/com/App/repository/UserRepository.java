package com.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
    
    //public void registerUser(User user);
}
