package com.lauracercas.moviecards.dao.movie;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.repositories.MovieJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    @Autowired
    MovieJPA movieJPA;

    @Override
    public List<Movie> getAllMovies() {
        return movieJPA.findAll();
    }

    @Override
    public Movie save(Movie movie) {
        return movieJPA.save(movie);
    }

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieJPA.findById(movieId).orElse(null);
    }
}
