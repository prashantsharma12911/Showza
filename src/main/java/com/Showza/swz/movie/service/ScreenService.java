package com.Showza.swz.movie.service;

import java.util.List;

import com.Showza.swz.movie.model.Screen;

public interface ScreenService {

    Screen create(Screen screen);

    Screen getById(Long id);

    List<Screen> getAll();

    Screen update(Long id, Screen screen);

    void delete(Long id);
}
