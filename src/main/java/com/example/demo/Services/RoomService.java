package com.example.demo.Services;

import com.example.demo.IServices.IRoomService;
import com.example.demo.entities.Room;
import com.example.demo.repositories.IRoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.List;

@Service
public class RoomService implements IRoomService{
    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public List<Room> getRooms(Integer movieId, Integer branchId, String startDate, String startTime) {
        return roomRepository.getRoomByMovieAndSchedule(movieId, LocalDate.parse(startDate));
    }
}
