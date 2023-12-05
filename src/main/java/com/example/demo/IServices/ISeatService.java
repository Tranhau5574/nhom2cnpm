package com.example.demo.IServices;

import java.util.List;

import com.example.demo.DTOs.SeatDTO;

public interface ISeatService {
    List<SeatDTO> getSeatsByScheduleId(Integer scheduleId);
}
