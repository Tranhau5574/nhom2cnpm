package com.example.demo.Services;

import com.example.demo.IServices.IRoomService;
import com.example.demo.entities.Room;
import com.example.demo.reporitories.IRoomRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService{
    @Autowired
    private IRoomRepository roomRepository;


    @Override
    public List<Room> getRooms(Integer movieId, Integer branchId, String startDate, String startTime) {
        return roomRepository.getRoomByMovieAndSchedule(movieId, LocalDate.parse(startDate));
    }
}
