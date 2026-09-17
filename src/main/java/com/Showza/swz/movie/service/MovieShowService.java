package com.Showza.swz.movie.service;

import java.util.List;

import com.Showza.swz.movie.model.MovieShow;

public interface MovieShowService {

    MovieShow create(MovieShow movieShow);

    MovieShow getById(Long id);

    List<MovieShow> getAll();

    MovieShow update(Long id, MovieShow movieShow);

    void delete(Long id);
}
