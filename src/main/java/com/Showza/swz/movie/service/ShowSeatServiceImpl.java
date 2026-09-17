package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movie.model.ShowSeat;
import com.Showza.swz.movie.repository.ShowSeatRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    private final ShowSeatRepository showSeatRepository;

    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    @Override
    public ShowSeat create(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    @Override
    public ShowSeat getById(Long id) {
        return showSeatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShowSeat not found with id: " + id));
    }

    @Override
    public List<ShowSeat> getAll() {
        return showSeatRepository.findAll();
    }

    @Override
    public ShowSeat update(Long id, ShowSeat showSeat) {
        ShowSeat existing = getById(id);
        showSeat.setId(existing.getId());
        return showSeatRepository.save(showSeat);
    }

    @Override
    public void delete(Long id) {
        showSeatRepository.delete(getById(id));
    }
}
