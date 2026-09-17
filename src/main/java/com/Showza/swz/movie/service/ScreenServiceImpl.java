package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movie.model.Screen;
import com.Showza.swz.movie.repository.ScreenRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Override
    public Screen create(Screen screen) {
        return screenRepository.save(screen);
    }

    @Override
    public Screen getById(Long id) {
        return screenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Screen not found with id: " + id));
    }

    @Override
    public List<Screen> getAll() {
        return screenRepository.findAll();
    }

    @Override
    public Screen update(Long id, Screen screen) {
        Screen existing = getById(id);
        screen.setId(existing.getId());
        return screenRepository.save(screen);
    }

    @Override
    public void delete(Long id) {
        screenRepository.delete(getById(id));
    }
}
