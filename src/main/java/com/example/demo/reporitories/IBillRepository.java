package com.example.demo.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Bill;

public interface IBillRepository extends JpaRepository<Bill, Integer> {
}