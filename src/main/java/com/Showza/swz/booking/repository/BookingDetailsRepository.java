package com.Showza.swz.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.booking.model.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {
}
