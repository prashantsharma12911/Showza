package com.Showza.swz.refund.model;

import com.Showza.swz.payment.model.PaymentDetails;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "refund_details")
public class RefundDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false, unique = true)
    private PaymentDetails refundAgainstPayment;

    @Column(nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RefundStatus status;

    public RefundDetails() {
    }

    public RefundDetails(PaymentDetails refundAgainstPayment, Double amount, RefundStatus status) {
        this.refundAgainstPayment = refundAgainstPayment;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentDetails getRefundAgainstPayment() {
        return refundAgainstPayment;
    }

    public void setRefundAgainstPayment(PaymentDetails refundAgainstPayment) {
        this.refundAgainstPayment = refundAgainstPayment;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public RefundStatus getStatus() {
        return status;
    }

    public void setStatus(RefundStatus status) {
        this.status = status;
    }
}
