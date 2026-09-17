package com.Showza.swz.refund.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.refund.model.RefundDetails;

public interface RefundDetailsRepository extends JpaRepository<RefundDetails, Long> {
}
