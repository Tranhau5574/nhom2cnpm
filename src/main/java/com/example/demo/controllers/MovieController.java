package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.Services.MovieService;
import com.example.demo.entities.Movie;
import com.example.demo.entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/movie-details")
public class MovieController {

    @Autowired 
    MovieService movieService;

    @GetMapping
    public String displayMovieDetailPage(@RequestParam Integer movieId, Model model, HttpServletRequest request){
   
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie",movie);
        return "movie-details";
    }
}
