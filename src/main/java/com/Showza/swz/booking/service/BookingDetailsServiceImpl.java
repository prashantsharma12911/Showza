package com.Showza.swz.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.booking.model.BookingDetails;
import com.Showza.swz.booking.repository.BookingDetailsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {

    private final BookingDetailsRepository bookingDetailsRepository;

    public BookingDetailsServiceImpl(BookingDetailsRepository bookingDetailsRepository) {
        this.bookingDetailsRepository = bookingDetailsRepository;
    }

    @Override
    public BookingDetails create(BookingDetails bookingDetails) {
        return bookingDetailsRepository.save(bookingDetails);
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
