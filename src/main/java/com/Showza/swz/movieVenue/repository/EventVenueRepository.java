package com.Showza.swz.movieVenue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.movieVenue.model.EventVenue;

public interface EventVenueRepository extends JpaRepository<EventVenue, Long> {
}
