package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Bill;

public interface IBillRepository extends JpaRepository<Bill, Integer> {}