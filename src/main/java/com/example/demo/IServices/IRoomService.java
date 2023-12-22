package com.example.demo.IServices;

import java.util.List;

import com.example.demo.entities.Room;

public interface IRoomService {
    Room findRoomById(Integer roomId);

    List<Room> findAllRoom();
}


