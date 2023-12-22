package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Room;

public interface IRoomRepository extends JpaRepository<Room,Integer> {
    Room findRoomById(Integer id);

    List<Room> findAll();

    @Query("SELECT r FROM Room r WHERE r.id IN (SELECT s.room.id FROM Schedule s WHERE s.movie.id=:movieId AND " +
            "s.startDate=:startDate)")
    List<Room> getRoomByMovieAndSchedule(@Param("movieId")   Integer movieId,
                                         @Param("startDate") LocalDate startDate);
}
