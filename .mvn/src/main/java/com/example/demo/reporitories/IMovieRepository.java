package com.example.demo.reporitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer>{
       
    Movie findMovieByName(String name);
    Movie findMovieById(Integer id);
}
