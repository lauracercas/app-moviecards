package com.lauracercas.moviecards.service.movie;


import com.lauracercas.moviecards.dao.movie.MovieDao;
import com.lauracercas.moviecards.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao movieDao;

    public MovieServiceImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieDao.getAllMovies();
    }

    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie getMovieById(Integer movieId) {
        return movieDao.getMovieById(movieId);
    }
}
