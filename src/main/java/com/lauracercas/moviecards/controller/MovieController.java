package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public String getMoviesList(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "movies/list";
    }

    @GetMapping("movies/new")
    public String newMovie(Model model) {
        model.addAttribute("movie", new Movie());
        model.addAttribute("title", "Nueva Película");
        return "movies/form";
    }

    @PostMapping("saveMovie")
    public String saveMovie(@ModelAttribute Movie movie, BindingResult result, Model model) {
        model.addAttribute("title", "Nuevo Movie");
        if (result.hasErrors()) {
            return "movies/form";
        }
        Movie movieSaved = movieService.save(movie);
        model.addAttribute("message", "Película guardada correctamente");

        model.addAttribute("movie", movieSaved);
        model.addAttribute("title", "Editar Película");
        return "movies/form";
    }

    @GetMapping("editMovie/{movieId}")
    public String editMovie(@PathVariable Integer movieId, Model model) {
        Movie movie = movieService.getMovieById(movieId);
        List<Actor> actors = movie.getActors();
        model.addAttribute("movie", movie);
        model.addAttribute("actors", actors);

        model.addAttribute("title", "Editar Película");

        return "movies/form";
    }


}
