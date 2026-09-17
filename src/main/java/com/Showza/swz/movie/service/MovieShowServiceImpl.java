package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movie.model.MovieShow;
import com.Showza.swz.movie.repository.MovieShowRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieShowServiceImpl implements MovieShowService {

    private final MovieShowRepository movieShowRepository;

    public MovieShowServiceImpl(MovieShowRepository movieShowRepository) {
        this.movieShowRepository = movieShowRepository;
    }

    @Override
    public MovieShow create(MovieShow movieShow) {
        return movieShowRepository.save(movieShow);
    }

    @Override
    public MovieShow getById(Long id) {
        return movieShowRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("MovieShow not found with id: " + id));
    }

    @Override
    public List<MovieShow> getAll() {
        return movieShowRepository.findAll();
    }

    @Override
    public MovieShow update(Long id, MovieShow movieShow) {
        MovieShow existing = getById(id);
        movieShow.setId(existing.getId());
        return movieShowRepository.save(movieShow);
    }

    @Override
    public void delete(Long id) {
        movieShowRepository.delete(getById(id));
    }
}
