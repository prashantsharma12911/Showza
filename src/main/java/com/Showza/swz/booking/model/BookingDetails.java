package com.Showza.swz.booking.model;

import com.Showza.swz.payment.model.PaymentDetails;
import com.Showza.swz.customer.model.User;
import com.Showza.swz.movie.model.MovieShow;
import com.Showza.swz.movie.model.ShowSeat;
import com.Showza.swz.offer.model.Offer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "movie_show_id", nullable = false)
    private MovieShow movieShow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "show_seat_id", nullable = false)
    private ShowSeat showSeat;

    @OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
    private PaymentDetails payment;

    public BookingDetails() {
    }

    public BookingDetails(User user, MovieShow movieShow, Offer offer, BookingStatus status, Double amount,
            ShowSeat showSeat) {
        this.user = user;
        this.movieShow = movieShow;
        this.offer = offer;
        this.status = status;
        this.amount = amount;
        this.showSeat = showSeat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public void setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ShowSeat getShowSeat() {
        return showSeat;
    }

    public void setShowSeat(ShowSeat showSeat) {
        this.showSeat = showSeat;
    }

    public PaymentDetails getPayment() {
        return payment;
    }

    public void setPayment(PaymentDetails payment) {
        this.payment = payment;
    }
}
