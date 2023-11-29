package com.example.demo.reporitories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Schedule;

public interface IScheduleRepository extends JpaRepository<Schedule, Integer>{
    Schedule findScheduleById(Integer id);

    @Query("SELECT s FROM Schedule s WHERE s.startDate = :startDate ORDER BY s.startTime")
    List<Schedule> getScheduleByStartDate(
        @Param("startDate") LocalDate startDate
    );
}