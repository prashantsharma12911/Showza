package com.Showza.swz.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Showza.swz.booking.model.BookingDetails;
import com.Showza.swz.booking.model.BookingStatus;
import com.Showza.swz.booking.repository.BookingDetailsRepository;
import com.Showza.swz.movie.model.ShowSeat;
import com.Showza.swz.movie.model.ShowSeatStatus;
import com.Showza.swz.movie.repository.ShowSeatRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

    private final BookingDetailsRepository bookingDetailsRepository;
    private final ShowSeatRepository showSeatRepository;
    private final SeatLockService seatLockService;

    public BookingDetailsServiceImpl(BookingDetailsRepository bookingDetailsRepository,
            ShowSeatRepository showSeatRepository, SeatLockService seatLockService) {
        this.bookingDetailsRepository = bookingDetailsRepository;
        this.showSeatRepository = showSeatRepository;
        this.seatLockService = seatLockService;
    }

    @Override
    public BookingDetails create(BookingDetails bookingDetails) {
        Long showSeatId = bookingDetails.getShowSeat().getId();
        Long userId = bookingDetails.getUser().getId();

        ShowSeat showSeat = showSeatRepository.findById(showSeatId)
                .orElseThrow(() -> new EntityNotFoundException("ShowSeat not found with id: " + showSeatId));
        if (showSeat.getStatus() == ShowSeatStatus.BOOKED) {
            throw new SeatUnavailableException("Seat is already booked");
        }
        if (!seatLockService.tryLock(showSeatId, userId)) {
            throw new SeatUnavailableException("Seat is currently held by another user");
        }

        try {
            bookingDetails.setStatus(BookingStatus.PENDING);
            return bookingDetailsRepository.save(bookingDetails);
        } catch (RuntimeException e) {
            seatLockService.release(showSeatId, userId);
            throw e;
        }
    }

    @Override
    @Transactional(noRollbackFor = SeatUnavailableException.class)
    public BookingDetails confirm(Long id) {
        BookingDetails booking = getById(id);
        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new SeatUnavailableException("Booking is not pending");
        }
        Long showSeatId = booking.getShowSeat().getId();
        Long userId = booking.getUser().getId();

        if (!seatLockService.isLockedBy(showSeatId, userId)) {
            booking.setStatus(BookingStatus.CANCELLED);
            bookingDetailsRepository.save(booking);
            throw new SeatUnavailableException("Seat hold expired, please book again");
        }
        if (showSeatRepository.updateStatus(showSeatId, ShowSeatStatus.AVAILABLE, ShowSeatStatus.BOOKED) == 0) {
            booking.setStatus(BookingStatus.CANCELLED);
            bookingDetailsRepository.save(booking);
            seatLockService.release(showSeatId, userId);
            throw new SeatUnavailableException("Seat is already booked");
        }

        booking.setStatus(BookingStatus.CONFIRMED);
        BookingDetails saved = bookingDetailsRepository.save(booking);
        seatLockService.release(showSeatId, userId);
        return saved;
    }

    @Override
    public BookingDetails getById(Long id) {
        return bookingDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("BookingDetails not found with id: " + id));
    }

    @Override
    public List<BookingDetails> getAll() {
        return bookingDetailsRepository.findAll();
    }

    @Override
    public BookingDetails update(Long id, BookingDetails bookingDetails) {
        BookingDetails existing = getById(id);
        bookingDetails.setId(existing.getId());
        return bookingDetailsRepository.save(bookingDetails);
    }

    @Override
    public void delete(Long id) {
        bookingDetailsRepository.delete(getById(id));
    }
}
