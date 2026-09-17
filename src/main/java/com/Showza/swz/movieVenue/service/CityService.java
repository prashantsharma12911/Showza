package com.Showza.swz.movieVenue.service;

import java.util.List;

import com.Showza.swz.movieVenue.model.City;

public interface CityService {

    City create(City city);

    City getById(Long id);

    List<City> getAll();

    City update(Long id, City city);

    void delete(Long id);
}
