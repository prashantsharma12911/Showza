package com.Showza.swz.movieVenue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movieVenue.model.City;
import com.Showza.swz.movieVenue.repository.CityRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City getById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("City not found with id: " + id));
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City update(Long id, City city) {
        City existing = getById(id);
        city.setId(existing.getId());
        return cityRepository.save(city);
    }

    @Override
    public void delete(Long id) {
        cityRepository.delete(getById(id));
    }
}
