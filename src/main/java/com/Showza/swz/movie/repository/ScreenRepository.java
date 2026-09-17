package com.Showza.swz.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.movie.model.Screen;

public interface ScreenRepository extends JpaRepository<Screen, Long> {
}
