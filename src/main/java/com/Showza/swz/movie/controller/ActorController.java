package com.Showza.swz.movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Showza.swz.movie.model.Actor;
import com.Showza.swz.movie.service.ActorService;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actor create(@RequestBody Actor actor) {
        return actorService.create(actor);
    }

    @GetMapping("/{id}")
    public Actor getById(@PathVariable Long id) {
        return actorService.getById(id);
    }

    @GetMapping
    public List<Actor> getAll() {
        return actorService.getAll();
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor) {
        return actorService.update(id, actor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        actorService.delete(id);
    }
}
