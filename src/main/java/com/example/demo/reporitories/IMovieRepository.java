package com.example.demo.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    // Add your custom methods here
       
    Movie findMovieByName(String name);
    
    Movie findMovieById(Integer id);
}
