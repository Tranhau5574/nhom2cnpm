package com.example.demo.IServices;

import java.util.List;

import com.example.demo.entities.Seat;

public interface ISeatService {
    List<Seat> getSeatsByScheduleId(Integer scheduleId);
}
