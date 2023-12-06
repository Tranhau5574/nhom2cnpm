package com.example.demo.IServices;


import com.example.demo.entities.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface IScheduleService {
    List<String> getStartTimes(Integer movieId, LocalDate startDate);
    Schedule getSchedules(Integer movieId, String startDate, String startTime);
}
