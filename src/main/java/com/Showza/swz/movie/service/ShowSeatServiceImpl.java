package com.Showza.swz.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.booking.service.SeatLockService;
import com.Showza.swz.movie.model.ShowSeat;
import com.Showza.swz.movie.repository.ShowSeatRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    private final ShowSeatRepository showSeatRepository;

    private final SeatLockService seatLockService;

    public ShowSeatServiceImpl(ShowSeatRepository showSeatRepository, SeatLockService seatLockService) {
        this.showSeatRepository = showSeatRepository;
        this.seatLockService = seatLockService;
    }

    private ShowSeat markHeld(ShowSeat showSeat) {
        showSeat.setHeld(seatLockService.isLocked(showSeat.getId()));
        return showSeat;
    }

    @Override
    public ShowSeat create(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    @Override
    public ShowSeat getById(Long id) {
        return markHeld(showSeatRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShowSeat not found with id: " + id)));
    }

    @Override
    public List<ShowSeat> getAll() {
        List<ShowSeat> seats = showSeatRepository.findAll();
        seats.forEach(this::markHeld);
        return seats;
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
