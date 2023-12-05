package com.example.demo.reporitories;

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

    List<Schedule> getSchedulesByMovie_IdAndBranch_IdAndStartDateAndStartTimeAndRoom_Id(Integer movieId,Integer branchId
    , LocalDate startDate,LocalTime startTime,Integer roomId);
}