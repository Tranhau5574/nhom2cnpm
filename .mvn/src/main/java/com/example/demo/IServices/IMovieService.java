package com.example.demo.IServices;

import java.util.List;

import com.example.demo.entities.Movie;
 

public interface IMovieService {

    Movie getMovieById(int id);

    Movie getMovieByName(String name);
} 

