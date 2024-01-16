//package com.lauracercas.moviecards.integrationtest.repositories;
//
//import com.lauracercas.moviecards.integrationtest.FlywayTestConfiguration;
//import com.lauracercas.moviecards.integrationtest.TestContainersDatabaseConfig;
//import com.lauracercas.moviecards.model.Actor;
//import com.lauracercas.moviecards.repositories.ActorJPA;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//@ActiveProfiles("test")
//@ContextConfiguration(classes = FlywayTestConfiguration.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class ActorJPAIT extends TestContainersDatabaseConfig {
//
//    @Autowired
//    ActorJPA actorJPA;
//
//    @Test
//    public void debeCrearYRecuperarActor() {
//        // Crear un nuevo actor
//        Actor actor = new Actor();
//        actor.setName("John Doe");
//
//        // Guardar el actor en la base de datos
//        actorJPA.save(actor);
//
//        // Recuperar el actor por el ID
//        Optional<Actor> actorRecuperado = actorJPA.findById(actor.getId());
//
//        // Verificar que el actor se haya guardado correctamente
//        Assertions.assertTrue(actorRecuperado.isPresent());
//        assertEquals(actor.getName(), actorRecuperado.get().getName());
//    }
//
////    @Test
////    void shouldFindActor() {
////        Actor actor = actorJPA.findById(1).orElse(null);
////        assert actor != null;
////        assertEquals("Actor1",actor.getName());
////
////    }
//}
