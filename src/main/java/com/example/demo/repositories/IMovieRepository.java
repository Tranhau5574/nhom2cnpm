package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    List<Movie> findAll();

    Movie findMovieByName(String name);
    
    Movie findMovieById(Integer id);
}
   