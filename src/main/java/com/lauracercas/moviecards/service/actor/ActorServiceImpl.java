package com.lauracercas.moviecards.service.actor;


import com.lauracercas.moviecards.dao.actor.ActorDao;
import com.lauracercas.moviecards.model.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorDao actorDao;

    @Override
    public List<Actor> getAllActors() {
        return actorDao.getAllActors();
    }

    @Override
    public Actor save(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public Actor getActorById(Integer actorId) {
        return actorDao.getActorById(actorId);
    }
}
