package com.lauracercas.moviecards.controller;

import com.lauracercas.moviecards.model.Actor;
import com.lauracercas.moviecards.model.Movie;
import com.lauracercas.moviecards.service.actor.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public String getActorsList(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actors/list";
    }

    @GetMapping("actors/new")
    public String newActor(Model model) {
        model.addAttribute("actor", new Actor());
        model.addAttribute("title", "Nuevo Actor");
        return "actors/form";
    }

    @PostMapping("saveActor")
    public String saveActor(@ModelAttribute Actor actor, BindingResult result, Model model) {
        model.addAttribute("title", "Nuevo Actor");
        if (result.hasErrors()) {
            return "actors/form";
        }
        Actor actorSaved = actorService.save(actor);
        if (actor.getId() != null) {
            model.addAttribute("message", "Actor actualizado correctamente");
        } else {
            model.addAttribute("message", "Actor guardado correctamente");
        }

        model.addAttribute("actor", actorSaved);
        model.addAttribute("title", "Editar Actor");
        return "actors/form";
    }

    @GetMapping("editActor/{actorId}")
    public String editActor(@PathVariable Integer actorId, Model model) {
        Actor actor = actorService.getActorById(actorId);
        List<Movie> movies = actor.getMovies();
        model.addAttribute("actor", actor);
        model.addAttribute("movies", movies);

        model.addAttribute("title", "Editar Actor");

        return "actors/form";
    }


}
