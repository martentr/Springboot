package com.App.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.entity.Client;
import com.App.entity.User;

public interface ClientRepository extends JpaRepository<Client, Long> {
    // Custom query methods (if needed) can be added here
    List<Client> findByUser(User user);
}