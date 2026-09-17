package com.Showza.swz.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.payment.model.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {
}
