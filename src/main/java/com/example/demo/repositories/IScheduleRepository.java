package com.example.demo.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Room;
import com.example.demo.entities.Schedule;

public interface IScheduleRepository extends JpaRepository<Schedule, Integer>{

    @Query("SELECT s FROM Schedule s WHERE s.movie.id=:movieId")    
    List<Schedule> findAllByMovieId(@Param("movieId") Integer movieId);

    @Query("SELECT DISTINCT s.startDate FROM Schedule s WHERE s.movie.id=:movieId")
    List<LocalDate> getStartDateByMovie_Id(@Param("movieId")   Integer movieId);

    @Query("SELECT DISTINCT s.startTime FROM Schedule s WHERE s.movie.id=:movieId" 
            + " AND s.startDate=:startDate")
    List<LocalTime> getStartTimeByMovie_IdAndStartDate(
                  @Param("movieId")   Integer movieId
                , @Param("startDate") LocalDate startDate);

    @Query("SELECT s FROM Schedule s WHERE s.movie.id=:movieId" 
            + " AND s.startDate=:startDate AND s.startTime=:startTime")
    Schedule findSchedulesByMovie_IdAndStartDateAndStartTime(
                  @Param("movieId")   Integer movieId
                , @Param("startDate") LocalDate startDate
                , @Param("startTime") LocalTime startTime);

    @Query("SELECT s FROM Schedule s WHERE s.movie.id=:movieId" 
            + " AND s.startDate=:startDate")
    List<Schedule> getSchedulesByMovie_IdAndStartDate(
                  @Param("movieId")   Integer movieId
                , @Param("startDate") LocalDate startDate);

    void deleteByMovie_IdAndStartDate(
                  @Param("movieId")   Integer movieId
                , @Param("startDate") LocalDate startDate);

    void deleteById(Integer id);

    @Query("SELECT s FROM Schedule s WHERE s.room.id=:roomId" 
            + " AND s.startDate=:startDate AND s.startTime=:startTime")
    Optional<Schedule> findByRoomAndTimeAndDate(
                  @Param("startDate") LocalDate startDate
                , @Param("startTime") LocalTime startTime
                , @Param("roomId") Integer roomId);
}