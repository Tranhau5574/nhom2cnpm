package com.example.demo.Services;

import java.util.List;

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
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById( int id){
        return movieRepository.findMovieById(id);
    };

    public Movie getMovieByName(String name){
        return movieRepository.findMovieByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
} 
