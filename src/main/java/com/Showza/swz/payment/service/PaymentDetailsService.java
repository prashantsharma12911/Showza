package com.Showza.swz.payment.service;

import java.util.List;

import com.Showza.swz.payment.model.PaymentDetails;

public interface PaymentDetailsService {

    PaymentDetails create(PaymentDetails paymentDetails);

    PaymentDetails getById(Long id);

    List<PaymentDetails> getAll();

    PaymentDetails update(Long id, PaymentDetails paymentDetails);

    void delete(Long id);
}
