package com.lauracercas.moviecards.dao.movie;

import com.lauracercas.moviecards.model.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> getAllMovies();

    Movie save(Movie movie);

    Movie getMovieById(Integer movieId);
}
