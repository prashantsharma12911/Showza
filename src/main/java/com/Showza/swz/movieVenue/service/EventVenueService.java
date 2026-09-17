package com.Showza.swz.movieVenue.service;

import java.util.List;

import com.Showza.swz.movieVenue.model.EventVenue;

public interface EventVenueService {

    EventVenue create(EventVenue eventVenue);

    EventVenue getById(Long id);

    List<EventVenue> getAll();

    EventVenue update(Long id, EventVenue eventVenue);

    void delete(Long id);
}
