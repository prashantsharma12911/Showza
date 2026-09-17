package com.Showza.swz.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.movie.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
