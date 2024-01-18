package com.lauracercas.moviecards.integrationtest.repositories;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.repositories.ActorJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ActorJPAIT {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ActorJPA actorJPA;

    @Test
    public void testCreateActor() {
        // given
        Actor actor = new Actor();
        actor.setName("actor");
        actor.setBirthDate(new Date());

        // when
        actorJPA.save(actor);

        // then
        Actor foundActor = entityManager.find(Actor.class, actor.getId());
        assertEquals(actor, foundActor);
    }
}
