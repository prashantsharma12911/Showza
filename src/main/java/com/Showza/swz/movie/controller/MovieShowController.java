package com.Showza.swz.movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Showza.swz.movie.model.MovieShow;
import com.Showza.swz.movie.service.MovieShowService;

@RestController
@RequestMapping("/api/movie-shows")
public class MovieShowController {

    private final MovieShowService movieShowService;

    public MovieShowController(MovieShowService movieShowService) {
        this.movieShowService = movieShowService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieShow create(@RequestBody MovieShow movieShow) {
        return movieShowService.create(movieShow);
    }

    @GetMapping("/{id}")
    public MovieShow getById(@PathVariable Long id) {
        return movieShowService.getById(id);
    }

    @GetMapping
    public List<MovieShow> getAll() {
        return movieShowService.getAll();
    }

    @PutMapping("/{id}")
    public MovieShow update(@PathVariable Long id, @RequestBody MovieShow movieShow) {
        return movieShowService.update(id, movieShow);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        movieShowService.delete(id);
    }
}
