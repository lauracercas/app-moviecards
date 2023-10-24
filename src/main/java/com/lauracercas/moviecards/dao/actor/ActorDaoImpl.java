package com.lauracercas.moviecards.dao.actor;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.repositories.ActorJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActorDaoImpl implements ActorDao{

    @Autowired
    ActorJPA actorJPA;

    @Override
    public List<Actor> getAllActors() {
        return actorJPA.findAll();
    }

    @Override
    public Actor save(Actor actor) {
        return actorJPA.save(actor);
    }

    @Override
    public Actor getActorById(Integer actorId) {
        return actorJPA.findById(actorId).orElse(null);
    }


}
