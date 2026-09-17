package com.Showza.swz.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.movie.model.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
