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

import com.Showza.swz.movie.model.Seat;
import com.Showza.swz.movie.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seat create(@RequestBody Seat seat) {
        return seatService.create(seat);
    }

    @GetMapping("/{id}")
    public Seat getById(@PathVariable Long id) {
        return seatService.getById(id);
    }

    @GetMapping
    public List<Seat> getAll() {
        return seatService.getAll();
    }

    @PutMapping("/{id}")
    public Seat update(@PathVariable Long id, @RequestBody Seat seat) {
        return seatService.update(id, seat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        seatService.delete(id);
    }
}
