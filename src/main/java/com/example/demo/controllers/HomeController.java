package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.Services.MovieService;
import com.example.demo.entities.Movie;

@Controller
public class HomeController {

    @Autowired
    MovieService movieService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMoviesByID(Model model) {
        System.out.println("This is home");
        List<Movie> movieList = movieService.findAll();
        model.addAttribute("movies", movieList);
        return "homepage";
    }
    
    @PostMapping("/")
    public String findMovies(Model model, HttpServletRequest request){
        model.addAttribute("movie", movieService.getMovieByName(request.getParameter("movie-name")));
        return "movie-details";
    }
}
