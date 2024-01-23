package com.lauracercas.moviecards.repositories;

import com.lauracercas.moviecards.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJPA extends JpaRepository<Movie, Integer> {


}
