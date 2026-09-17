package com.Showza.swz.refund.controller;

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

import com.Showza.swz.refund.model.RefundDetails;
import com.Showza.swz.refund.service.RefundDetailsService;

@RestController
@RequestMapping("/api/refunds")
public class RefundDetailsController {

    private final RefundDetailsService refundDetailsService;

    public RefundDetailsController(RefundDetailsService refundDetailsService) {
        this.refundDetailsService = refundDetailsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RefundDetails create(@RequestBody RefundDetails refundDetails) {
        return refundDetailsService.create(refundDetails);
    }

    @GetMapping("/{id}")
    public RefundDetails getById(@PathVariable Long id) {
        return refundDetailsService.getById(id);
    }

    @GetMapping
    public List<RefundDetails> getAll() {
        return refundDetailsService.getAll();
    }

    @PutMapping("/{id}")
    public RefundDetails update(@PathVariable Long id, @RequestBody RefundDetails refundDetails) {
        return refundDetailsService.update(id, refundDetails);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        refundDetailsService.delete(id);
    }
}
