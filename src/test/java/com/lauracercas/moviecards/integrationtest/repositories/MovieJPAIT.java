package com.lauracercas.moviecards.integrationtest.repositories;

import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.repositories.MovieJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MovieJPAIT {

    @Autowired
    private MovieJPA movieJPA;

    @Test
    public void testSaveMovie() {
        Movie movie = new Movie();
        movie.setTitle("Movie");
        movie.setCountry("country");

        Movie savedMovie = movieJPA.save(movie);

        assertNotNull(savedMovie.getId());

        Optional<Movie> foundMovie = movieJPA.findById(savedMovie.getId());

        assertTrue(foundMovie.isPresent());
        assertEquals(savedMovie, foundMovie.get());
    }

    @Test
    public void testFindById() {
        Movie movie = new Movie();
        movie.setTitle("movie2");
        Movie savedMovie = movieJPA.save(movie);

        Optional<Movie> foundMovie = movieJPA.findById(savedMovie.getId());
        assertTrue(foundMovie.isPresent());
        assertEquals(savedMovie, foundMovie.get()); 
    }
}
