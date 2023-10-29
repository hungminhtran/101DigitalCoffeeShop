package com.digital.coffee.shop.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PromotionEntity implements Serializable {
    @Id private Long promotionId;
    private Long shopId;
    private Long customerId;
    private Float promotionValue;

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Float getPromotionValue() {
        return promotionValue;
    }

    public void setPromotionValue(Float promotionValue) {
        this.promotionValue = promotionValue;
    }
}
