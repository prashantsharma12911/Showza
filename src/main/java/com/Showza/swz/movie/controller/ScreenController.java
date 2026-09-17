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

import com.Showza.swz.movie.model.Screen;
import com.Showza.swz.movie.service.ScreenService;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Screen create(@RequestBody Screen screen) {
        return screenService.create(screen);
    }

    @GetMapping("/{id}")
    public Screen getById(@PathVariable Long id) {
        return screenService.getById(id);
    }

    @GetMapping
    public List<Screen> getAll() {
        return screenService.getAll();
    }

    @PutMapping("/{id}")
    public Screen update(@PathVariable Long id, @RequestBody Screen screen) {
        return screenService.update(id, screen);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        screenService.delete(id);
    }
}
