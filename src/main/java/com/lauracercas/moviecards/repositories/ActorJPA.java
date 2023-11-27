package com.lauracercas.moviecards.repositories;

import com.lauracercas.moviecards.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorJPA extends JpaRepository<Actor, Integer> {


}
