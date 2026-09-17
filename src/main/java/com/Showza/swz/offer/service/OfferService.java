package com.Showza.swz.offer.service;

import java.util.List;

import com.Showza.swz.offer.model.Offer;

public interface OfferService {

    Offer create(Offer offer);

    Offer getById(Long id);

    List<Offer> getAll();

    Offer update(Long id, Offer offer);

    void delete(Long id);
}
