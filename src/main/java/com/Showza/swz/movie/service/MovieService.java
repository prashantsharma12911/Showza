package com.Showza.swz.movie.service;

import java.util.List;

import com.Showza.swz.movie.model.Movie;

public interface MovieService {

    Movie create(Movie movie);

    Movie getById(Long id);

    List<Movie> getAll();

    Movie update(Long id, Movie movie);

    void delete(Long id);
}
