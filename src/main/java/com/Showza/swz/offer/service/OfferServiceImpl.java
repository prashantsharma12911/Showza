package com.Showza.swz.offer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Showza.swz.offer.model.Offer;
import com.Showza.swz.offer.repository.OfferRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer create(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer getById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Offer not found with id: " + id));
    }

    @Override
    public List<Offer> getAll() {
        return offerRepository.findAll();
    }

    @Override
    public Offer update(Long id, Offer offer) {
        Offer existing = getById(id);
        offer.setId(existing.getId());
        return offerRepository.save(offer);
    }

    @Override
    public void delete(Long id) {
        offerRepository.delete(getById(id));
    }
}
