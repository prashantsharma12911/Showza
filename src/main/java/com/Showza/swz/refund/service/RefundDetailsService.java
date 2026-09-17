package com.Showza.swz.refund.service;

import java.util.List;

import com.Showza.swz.refund.model.RefundDetails;

public interface RefundDetailsService {

    RefundDetails create(RefundDetails refundDetails);

    RefundDetails getById(Long id);

    List<RefundDetails> getAll();

    RefundDetails update(Long id, RefundDetails refundDetails);

    void delete(Long id);
}
