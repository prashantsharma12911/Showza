package com.Showza.swz.refund.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.refund.model.RefundDetails;
import com.Showza.swz.refund.repository.RefundDetailsRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RefundDetailsServiceImpl implements RefundDetailsService {

    private final RefundDetailsRepository refundDetailsRepository;

    public RefundDetailsServiceImpl(RefundDetailsRepository refundDetailsRepository) {
        this.refundDetailsRepository = refundDetailsRepository;
    }

    @Override
    public RefundDetails create(RefundDetails refundDetails) {
        return refundDetailsRepository.save(refundDetails);
    }

    @Override
    public RefundDetails getById(Long id) {
        return refundDetailsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RefundDetails not found with id: " + id));
    }

    @Override
    public List<RefundDetails> getAll() {
        return refundDetailsRepository.findAll();
    }

    @Override
    public RefundDetails update(Long id, RefundDetails refundDetails) {
        RefundDetails existing = getById(id);
        refundDetails.setId(existing.getId());
        return refundDetailsRepository.save(refundDetails);
    }

    @Override
    public void delete(Long id) {
        refundDetailsRepository.delete(getById(id));
    }
}
