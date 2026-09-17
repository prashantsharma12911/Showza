package com.Showza.swz.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.movie.model.MovieShow;

public interface MovieShowRepository extends JpaRepository<MovieShow, Long> {
}
