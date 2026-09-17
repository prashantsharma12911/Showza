package com.Showza.swz.payment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.payment.model.PaymentDetails;
import com.Showza.swz.payment.repository.PaymentDetailsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    private final PaymentDetailsRepository paymentDetailsRepository;

    public PaymentDetailsServiceImpl(PaymentDetailsRepository paymentDetailsRepository) {
        this.paymentDetailsRepository = paymentDetailsRepository;
    }

    @Override
    public PaymentDetails create(PaymentDetails paymentDetails) {
        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public PaymentDetails getById(Long id) {
        return paymentDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("PaymentDetails not found with id: " + id));
    }

    @Override
    public List<PaymentDetails> getAll() {
        return paymentDetailsRepository.findAll();
    }

    @Override
    public PaymentDetails update(Long id, PaymentDetails paymentDetails) {
        PaymentDetails existing = getById(id);
        paymentDetails.setId(existing.getId());
        return paymentDetailsRepository.save(paymentDetails);
    }

    @Override
    public void delete(Long id) {
        paymentDetailsRepository.delete(getById(id));
    }
}
