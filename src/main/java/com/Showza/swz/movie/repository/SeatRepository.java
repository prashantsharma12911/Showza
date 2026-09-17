package com.Showza.swz.movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.movie.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
