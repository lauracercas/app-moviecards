package com.lauracercas.moviecards.service.card;


import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Card;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.actor.ActorService;
import com.lauracercas.moviecards.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    ActorService actorService;

    @Autowired
    MovieService movieService;


    @Override
    public String registerActorInMovie(Card card) {
        Integer actorId = card.getIdActor();
        Integer movieId = card.getIdMovie();

        Actor actor = actorService.getActorById(actorId);
        Movie movie = movieService.getMovieById(movieId);

        if (actor == null || movie == null) {
            return "Ha ocurrido un error";
        }

        if (movie.existActorInMovie(actor)) {
            return "Ya se ha inscrito este actor en esta película";
        }

        movie.addActor(actor);
        movieService.save(movie);
        return "Se ha registrado el actor en la película. Ficha creada correctamente";
    }




}
