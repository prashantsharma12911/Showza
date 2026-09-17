package com.Showza.swz.offer.controller;

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

import com.Showza.swz.offer.model.Offer;
import com.Showza.swz.offer.service.OfferService;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Offer create(@RequestBody Offer offer) {
        return offerService.create(offer);
    }

    @GetMapping("/{id}")
    public Offer getById(@PathVariable Long id) {
        return offerService.getById(id);
    }

    @GetMapping
    public List<Offer> getAll() {
        return offerService.getAll();
    }

    @PutMapping("/{id}")
    public Offer update(@PathVariable Long id, @RequestBody Offer offer) {
        return offerService.update(id, offer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        offerService.delete(id);
    }
}
