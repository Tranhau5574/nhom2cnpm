package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Seat;

public interface ISeatRepository extends JpaRepository<Seat,Integer>{

    List<Seat> getSeatByRoom_Id(Integer roomId);

    @Query("SELECT s.name FROM Seat s WHERE s.id = :seatId")
    String findSeatNameById(@Param("seatId") Integer seatId);
} 