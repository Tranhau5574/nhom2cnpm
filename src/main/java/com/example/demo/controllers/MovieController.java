package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.MovieService;
import com.example.demo.entities.Movie;

import java.time.LocalDate;

@Controller
public class MovieController {

    @Autowired 
    MovieService movieService;

    @RequestMapping(value = "/movie-details", method = RequestMethod.GET)
    public String displayMovieDetailPage(@RequestParam Integer movieId, Model model){
   
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute("movie",movie);
        return "movie-details";
    }

    @RequestMapping(value = "/admin/deleteMovie", method = RequestMethod.GET)
    public String deleteMovie(@RequestParam Integer movieId){
        movieService.deleteById(movieId);
        return "redirect:/admin/movie";
    }
    
    @RequestMapping(value = "/admin/addMovie", method = RequestMethod.GET)
    public String addMoviePage(){
        return "add-movie";
    }

    @RequestMapping(value = "/admin/addMovie", method = RequestMethod.POST)
    public String addMovie(@RequestParam("name") String name
                          ,@RequestParam("actors") String actors
                          ,@RequestParam("director") String director
                          ,@RequestParam("categories") String categories
                          ,@RequestParam("imgURL") String imgURL
                          ,@RequestParam("length") Integer length
                          ,@RequestParam("release-date") String release_date
                          ,@RequestParam("short-description") String short_description
                          ,@RequestParam("trailerURL") String trailerURL
                          ,@RequestParam("posterURL") String posterURL){

        Movie newMovie  = new Movie();
        newMovie.setName(name);
        newMovie.setActors(actors);
        newMovie.setCategories(categories);
        newMovie.setDirector(director);
        newMovie.setImgURL(imgURL);
        newMovie.setPosterURL(posterURL);
        newMovie.setTrailerURL(trailerURL);
        newMovie.setReleaseDate(LocalDate.parse(release_date));
        newMovie.setShortDescription(short_description);
        newMovie.setLength(length);

        Movie createdMovie = movieService.save(newMovie);
        return "redirect:/admin/movie";
    }
}
