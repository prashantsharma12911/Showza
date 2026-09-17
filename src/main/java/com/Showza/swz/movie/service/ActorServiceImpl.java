package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movie.model.Actor;
import com.Showza.swz.movie.repository.ActorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Actor getById(Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Actor not found with id: " + id));
    }

    @Override
    public List<Actor> getAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor update(Long id, Actor actor) {
        Actor existing = getById(id);
        actor.setId(existing.getId());
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Long id) {
        actorRepository.delete(getById(id));
    }
}
