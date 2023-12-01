package com.example.demo.IServices;

import java.util.List;

import com.example.demo.entities.Room;

public interface IRoomService {
    List<Room> getRooms(Integer movieId,Integer branchId,String startDate,String startTime);
}
