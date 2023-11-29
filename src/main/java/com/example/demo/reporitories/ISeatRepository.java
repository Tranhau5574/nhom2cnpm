package com.example.demo.reporitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Seat;

public interface ISeatRepository extends JpaRepository<Seat,Integer>{
    List<Seat> getSeatByRoom_Id(Integer roomId);
} 