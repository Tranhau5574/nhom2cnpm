package com.example.demo.security.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService{
    List<User> findAll();

    Optional<User> findById(Integer id);

    User save(User user);

    void remove(Integer id);

    Optional<User> findByUsername(String username);
}
