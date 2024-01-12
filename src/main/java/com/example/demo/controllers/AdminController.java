package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.MovieService;
import com.example.demo.Services.ScheduleService;
import com.example.demo.entities.Movie;

@Controller
public class AdminController {

    @Autowired
    MovieService movieService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/admin", method = RequestMethod.POST)       
    public String roleChosen(@RequestParam String roleSelected){
        if(roleSelected == "option1") return "admin";
        else return "redirect:/";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)       
    public String showAdminPage(){
        return "admin";
    }

    @RequestMapping(value = "/admin/movie", method = RequestMethod.GET)
    public String changeMoviePage(Model model){
        List<Movie> movieList = movieService.findAll();
        model.addAttribute("movieList", movieList);
        return "admin-movie";
    }

    @RequestMapping(value = "/admin/schedule", method = RequestMethod.GET)
    public String changeScheduleDate (@RequestParam("movieId") Integer movieId
                                    , @RequestParam(value = "error", defaultValue = "") String error
                                    , Model model){
        Movie movie = movieService.getMovieById(movieId);
        List<LocalDate> dateList = scheduleService.getStartDate(movieId);
        model.addAttribute("dateList", dateList);
        model.addAttribute("movie", movie);
        if(error.equals("error_1")){
            model.addAttribute("errorMessage", "Ngày thêm bị trùng! Thử lại đcmnguvcl");
        }
        model.addAttribute("error", error);
        return "admin-date";
    }
}
