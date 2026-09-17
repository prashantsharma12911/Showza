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

import com.Showza.swz.movieVenue.model.EventVenue;
import com.Showza.swz.movieVenue.service.EventVenueService;

@RestController
@RequestMapping("/api/venues")
public class EventVenueController {

    private final EventVenueService eventVenueService;

    public EventVenueController(EventVenueService eventVenueService) {
        this.eventVenueService = eventVenueService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventVenue create(@RequestBody EventVenue eventVenue) {
        return eventVenueService.create(eventVenue);
    }

    @GetMapping("/{id}")
    public EventVenue getById(@PathVariable Long id) {
        return eventVenueService.getById(id);
    }

    @GetMapping
    public List<EventVenue> getAll() {
        return eventVenueService.getAll();
    }

    @PutMapping("/{id}")
    public EventVenue update(@PathVariable Long id, @RequestBody EventVenue eventVenue) {
        return eventVenueService.update(id, eventVenue);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        eventVenueService.delete(id);
    }
}
