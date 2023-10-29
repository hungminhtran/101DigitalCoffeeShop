package com.digital.coffee.shop.jpa.entity;

import com.digital.coffee.shop.constants.PaymentStatus;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    private Long merchandiseSubTotal;
    private Long promotionSubtotal;
    private PaymentStatus paymentStatus;
    private Date paidAt;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getMerchandiseSubTotal() {
        return merchandiseSubTotal;
    }

    public void setMerchandiseSubTotal(Long merchandiseSubTotal) {
        this.merchandiseSubTotal = merchandiseSubTotal;
    }

    public Long getPromotionSubtotal() {
        return promotionSubtotal;
    }

    public void setPromotionSubtotal(Long promotionSubtotal) {
        this.promotionSubtotal = promotionSubtotal;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(Date paidAt) {
        this.paidAt = paidAt;
    }
}
