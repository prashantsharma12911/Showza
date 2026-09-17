package com.Showza.swz.movieVenue.controller;

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

import com.Showza.swz.movieVenue.model.City;
import com.Showza.swz.movieVenue.service.CityService;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City create(@RequestBody City city) {
        return cityService.create(city);
    }

    @GetMapping("/{id}")
    public City getById(@PathVariable Long id) {
        return cityService.getById(id);
    }

    @GetMapping
    public List<City> getAll() {
        return cityService.getAll();
    }

    @PutMapping("/{id}")
    public City update(@PathVariable Long id, @RequestBody City city) {
        return cityService.update(id, city);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cityService.delete(id);
    }
}
