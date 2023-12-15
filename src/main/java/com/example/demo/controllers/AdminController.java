package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.MovieService;
import com.example.demo.Services.ScheduleService;
import com.example.demo.entities.Movie;
import com.example.demo.entities.Schedule;

@Controller
public class AdminController {

    @Autowired
    MovieService movieService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/admin", method = RequestMethod.POST)       
    public String showPage(@RequestParam String roleSelected){
        if(roleSelected == "option1") return "AdminPage";
        else return "redirect:/";
    }

    @RequestMapping(value = "/admin/movie", method = RequestMethod.GET)
    public String changeMoviePage(Model model){
        List<Movie> movieList = movieService.findAll();
        model.addAttribute("movieList", movieList);
        return "admin-movie";
    }

    @RequestMapping(value = "/admin/schedule", method = RequestMethod.GET)
    public String changeScheduleDate(Model model, HttpServletRequest request){
        Integer selectedMovieId = Integer.parseInt(request.getParameter("selectedMovieId"));
        List<Schedule> scheduleList = scheduleService.findAllByMovieId(selectedMovieId);
        model.addAttribute("scheduleList", scheduleList);
        return "changeScheduleDate";
    }
}
