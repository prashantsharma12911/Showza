package com.Showza.swz.movie.service;

import java.util.List;

import com.Showza.swz.movie.model.Seat;

public interface SeatService {

    Seat create(Seat seat);

    Seat getById(Long id);

    List<Seat> getAll();

    Seat update(Long id, Seat seat);

    void delete(Long id);
}
