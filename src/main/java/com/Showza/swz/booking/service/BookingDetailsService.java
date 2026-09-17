package com.Showza.swz.booking.service;

import java.util.List;

import com.Showza.swz.booking.model.BookingDetails;

public interface BookingDetailsService {

    BookingDetails create(BookingDetails bookingDetails);

    BookingDetails getById(Long id);

    List<BookingDetails> getAll();

    BookingDetails update(Long id, BookingDetails bookingDetails);

    void delete(Long id);
}
