package com.example.demo.IServices;


import com.example.demo.entities.Movie;
import com.example.demo.entities.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IScheduleService {
    List<Schedule> findAllByMovieId(Integer movieId);

    List<String> getStartTimes(Integer movieId, LocalDate startDate);

    List<LocalDate>getStartDate(Integer movieId);

    Schedule getSchedules(Integer movieId, String startDate, String startTime);

    void deleteBystartDate(Integer movieId, String startDate);

    Schedule saveNewDate(String date, Integer movieId);

    List<Schedule> getSchedulesByMovie_IdAndStartDate(Integer movieId, String startDate);

    Optional<Schedule> findScheduleByRoomAndTimeAndDate(String date, String time, Integer roomId);
}