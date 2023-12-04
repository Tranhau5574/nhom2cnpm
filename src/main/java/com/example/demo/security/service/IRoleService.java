package com.example.demo.security.service;


import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Role;

public interface IRoleService{
    List<Role> findAll();

    Optional<Role> findById(Integer id);

    Role save(Role user);

    void remove(Integer id);

    Role findByName(String name);
}