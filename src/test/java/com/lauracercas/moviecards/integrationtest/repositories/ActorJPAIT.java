package com.lauracercas.moviecards.integrationtest.repositories;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.repositories.ActorJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class ActorJPAIT {

    @Autowired
    private ActorJPA actorJPA;

    @Test
    public void testSaveActor() {
        // given
        Actor actor = new Actor();
        actor.setName("actor");
        actor.setBirthDate(new Date());

        // when
        Actor savedActor = actorJPA.save(actor);

        // then
        assertNotNull(savedActor.getId()); // verifica que se asignó un ID

        // when
        Optional<Actor> foundActor = actorJPA.findById(savedActor.getId());

        // then
        assertTrue(foundActor.isPresent()); // verifica que el actor se puede recuperar de la base de datos
        assertEquals(savedActor, foundActor.get()); // verifica que el actor recuperado es el mismo que el actor
                                                    // guardado
    }

    @Test
    public void testFindById() {
        // given
        Actor actor = new Actor();
        actor.setName("actor");
        actor.setBirthDate(new Date());
        Actor savedActor = actorJPA.save(actor);

        // when
        Optional<Actor> foundActor = actorJPA.findById(savedActor.getId());

        // then
        assertTrue(foundActor.isPresent());
        assertEquals(savedActor, foundActor.get()); 
    }
}
