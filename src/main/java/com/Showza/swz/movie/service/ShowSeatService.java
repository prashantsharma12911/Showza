package com.Showza.swz.movie.service;

import java.util.List;

import com.Showza.swz.movie.model.ShowSeat;

public interface ShowSeatService {

    ShowSeat create(ShowSeat showSeat);

    ShowSeat getById(Long id);

    List<ShowSeat> getAll();

    ShowSeat update(Long id, ShowSeat showSeat);

    void delete(Long id);
}
