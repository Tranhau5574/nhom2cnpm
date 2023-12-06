package com.example.demo.IServices;

import java.util.List;

import com.example.demo.entities.Schedule;
import com.example.demo.entities.User;

public interface IBillService {
    void createNewBills(Schedule schedule, User user, List<Integer> listSelectedSeatIds) throws RuntimeException;
}
