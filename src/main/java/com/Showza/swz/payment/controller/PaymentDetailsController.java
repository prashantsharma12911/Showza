package com.Showza.swz.payment.controller;

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

import com.Showza.swz.payment.model.PaymentDetails;
import com.Showza.swz.payment.service.PaymentDetailsService;

@RestController
@RequestMapping("/api/payments")
public class PaymentDetailsController {

    private final PaymentDetailsService paymentDetailsService;

    public PaymentDetailsController(PaymentDetailsService paymentDetailsService) {
        this.paymentDetailsService = paymentDetailsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentDetails create(@RequestBody PaymentDetails paymentDetails) {
        return paymentDetailsService.create(paymentDetails);
    }

    @GetMapping("/{id}")
    public PaymentDetails getById(@PathVariable Long id) {
        return paymentDetailsService.getById(id);
    }

    @GetMapping
    public List<PaymentDetails> getAll() {
        return paymentDetailsService.getAll();
    }

    @PutMapping("/{id}")
    public PaymentDetails update(@PathVariable Long id, @RequestBody PaymentDetails paymentDetails) {
        return paymentDetailsService.update(id, paymentDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        paymentDetailsService.delete(id);
    }
}
