package com.lauracercas.moviecards.dao.actor;

import com.lauracercas.moviecards.model.Actor;

import java.util.List;

public interface ActorDao {

    List<Actor> getAllActors();

    Actor save(Actor actor);

    Actor getActorById(Integer actorId);
}
