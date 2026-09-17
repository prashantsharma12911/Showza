package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.movie.model.Seat;
import com.Showza.swz.movie.repository.SeatRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat create(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat getById(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Seat not found with id: " + id));
    }

    @Override
    public List<Seat> getAll() {
        return seatRepository.findAll();
    }

    @Override
    public Seat update(Long id, Seat seat) {
        Seat existing = getById(id);
        seat.setId(existing.getId());
        return seatRepository.save(seat);
    }

    @Override
    public void delete(Long id) {
        seatRepository.delete(getById(id));
    }
}
