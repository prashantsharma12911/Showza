package com.Showza.swz.movie.model;

import com.Showza.swz.movieVenue.model.EventVenue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "screens")
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "event_venue_id", nullable = false)
    private EventVenue eventVenue;

    @Column(nullable = false)
    private String name;

    public Screen() {
    }

    public Screen(EventVenue eventVenue, String name) {
        this.eventVenue = eventVenue;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EventVenue getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(EventVenue eventVenue) {
        this.eventVenue = eventVenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
