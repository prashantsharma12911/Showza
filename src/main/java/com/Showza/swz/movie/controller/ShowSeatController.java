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

import com.Showza.swz.movie.model.ShowSeat;
import com.Showza.swz.movie.service.ShowSeatService;

@RestController
@RequestMapping("/api/show-seats")
public class ShowSeatController {

    private final ShowSeatService showSeatService;

    public ShowSeatController(ShowSeatService showSeatService) {
        this.showSeatService = showSeatService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShowSeat create(@RequestBody ShowSeat showSeat) {
        return showSeatService.create(showSeat);
    }

    @GetMapping("/{id}")
    public ShowSeat getById(@PathVariable Long id) {
        return showSeatService.getById(id);
    }

    @GetMapping
    public List<ShowSeat> getAll() {
        return showSeatService.getAll();
    }

    @PutMapping("/{id}")
    public ShowSeat update(@PathVariable Long id, @RequestBody ShowSeat showSeat) {
        return showSeatService.update(id, showSeat);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        showSeatService.delete(id);
    }
}
