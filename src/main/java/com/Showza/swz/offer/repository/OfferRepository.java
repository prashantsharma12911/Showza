package com.Showza.swz.offer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Showza.swz.offer.model.Offer;

public interface OfferRepository extends JpaRepository<Offer, Long> {
}
