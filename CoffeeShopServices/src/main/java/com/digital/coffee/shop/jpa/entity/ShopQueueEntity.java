package com.digital.coffee.shop.jpa.entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShopQueueEntity implements Serializable {
    @Id private Long shopId;
    @Id private Long queueId;
    private Integer status;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getQueueId() {
        return queueId;
    }

    public void setQueueId(Long queueId) {
        this.queueId = queueId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
