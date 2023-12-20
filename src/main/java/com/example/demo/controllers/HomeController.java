package com.example.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.Services.MovieService;

@Controller
public class HomeController {

    @Autowired
    MovieService movieService;

    @GetMapping("/")
    public String displayHomePage(Model model) {
        System.out.println("This is home");
        return "homepage";
    }
    
    @PostMapping("/")
    public String findMovies(Model model, HttpServletRequest request){
        model.addAttribute("movie", movieService.getMovieByName(request.getParameter("movie-name")));
        return "homepage";
    }
}
