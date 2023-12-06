package com.example.demo.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Schedule;

public interface IScheduleRepository extends JpaRepository<Schedule, Integer>{
        
    @Query("SELECT DISTINCT s.startTime FROM Schedule s WHERE s.movie.id=:movieId" 
            + "AND s.startDate=:startDate")
    List<LocalTime> getStartTimeByMovie_IdAndStartDate(@Param("movieId") Integer movieId
            , @Param("startDate") LocalDate startDate);

    @Query("SELECT DISTINCT s.startTime FROM Schedule s WHERE s.movie.id=:movieId" 
            + "AND s.startDate=:startDate AND s.startTime=:startTime")
    Schedule findSchedulesByMovie_IdAndStartDateAndStartTime(
                          Integer movieId
                        , LocalDate startDate
                        , LocalTime startTime);
}