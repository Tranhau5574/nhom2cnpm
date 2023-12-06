package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.IServices.IMovieService;
import com.example.demo.entities.Movie;
import com.example.demo.repositories.IMovieRepository;


@Service
public class MovieService implements IMovieService{

    @Autowired
    IMovieRepository movieRepository;

    @Override
    public Movie getMovieById( int id){
        return movieRepository.findMovieById(id);
    };

    public Movie getMovieByName(String name){
        return movieRepository.findMovieByName(name);
    };
} 
