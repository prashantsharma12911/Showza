package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movie.model.Movie;
import com.Showza.swz.movie.repository.MovieRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie getById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie not found with id: " + id));
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie update(Long id, Movie movie) {
        Movie existing = getById(id);
        movie.setId(existing.getId());
        return movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.delete(getById(id));
    }
}
