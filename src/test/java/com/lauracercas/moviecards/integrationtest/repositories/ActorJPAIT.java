package com.lauracercas.moviecards.integrationtest.repositories;

import com.lauracercas.moviecards.integrationtest.SpringTest;
import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.repositories.ActorJPA;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ActorJPAIT extends SpringTest {


 @Test
 @Transactional @Rollback
 public void pruebaConexion(){
 assertTrue(session().isConnected());
 }

 @Test
 @Transactional
 public void testCreateActor() {
 Actor actor = new Actor();
 actor.setName("actor");
 actor.setBirthDate(new Date());

 session().persist(actor);
 session().flush();

 Actor foundActor = session().find(Actor.class, actor.getId());

 assertEquals(actor, foundActor);
 }

 }
