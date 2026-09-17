package com.Showza.swz.movieVenue.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movieVenue.model.EventVenue;
import com.Showza.swz.movieVenue.repository.EventVenueRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EventVenueServiceImpl implements EventVenueService {

    private final EventVenueRepository eventVenueRepository;

    public EventVenueServiceImpl(EventVenueRepository eventVenueRepository) {
        this.eventVenueRepository = eventVenueRepository;
    }

    @Override
    public EventVenue create(EventVenue eventVenue) {
        return eventVenueRepository.save(eventVenue);
    }

    @Override
    public EventVenue getById(Long id) {
        return eventVenueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("EventVenue not found with id: " + id));
    }

    @Override
    public List<EventVenue> getAll() {
        return eventVenueRepository.findAll();
    }

    @Override
    public EventVenue update(Long id, EventVenue eventVenue) {
        EventVenue existing = getById(id);
        eventVenue.setId(existing.getId());
        return eventVenueRepository.save(eventVenue);
    }

    @Override
    public void delete(Long id) {
        eventVenueRepository.delete(getById(id));
    }
}
