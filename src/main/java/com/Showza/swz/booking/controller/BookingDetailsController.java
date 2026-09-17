package com.Showza.swz.booking.controller;

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

import com.Showza.swz.booking.model.BookingDetails;
import com.Showza.swz.booking.service.BookingDetailsService;

@RestController
@RequestMapping("/api/bookings")
public class BookingDetailsController {

    private final BookingDetailsService bookingDetailsService;

    public BookingDetailsController(BookingDetailsService bookingDetailsService) {
        this.bookingDetailsService = bookingDetailsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookingDetails create(@RequestBody BookingDetails bookingDetails) {
        return bookingDetailsService.create(bookingDetails);
    }

    @GetMapping("/{id}")
    public BookingDetails getById(@PathVariable Long id) {
        return bookingDetailsService.getById(id);
    }

    @GetMapping
    public List<BookingDetails> getAll() {
        return bookingDetailsService.getAll();
    }

    @PutMapping("/{id}")
    public BookingDetails update(@PathVariable Long id, @RequestBody BookingDetails bookingDetails) {
        return bookingDetailsService.update(id, bookingDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookingDetailsService.delete(id);
    }
}
