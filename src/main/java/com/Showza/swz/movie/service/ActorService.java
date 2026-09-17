package com.Showza.swz.movie.service;

import java.util.List;

import com.Showza.swz.movie.model.Actor;

public interface ActorService {

    Actor create(Actor actor);

    Actor getById(Long id);

    List<Actor> getAll();

    Actor update(Long id, Actor actor);

    void delete(Long id);
}
