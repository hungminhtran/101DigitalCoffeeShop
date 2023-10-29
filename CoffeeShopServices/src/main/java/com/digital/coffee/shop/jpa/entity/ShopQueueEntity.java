package com.digital.coffee.shop.jpa.entity;

import com.digital.coffee.shop.constants.ShopQueueStatus;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShopQueueEntity implements Serializable {
    @Id private Long shopId;
    @Id private Long queueId;
    private ShopQueueStatus status;

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

    public ShopQueueStatus getStatus() {
        return status;
    }

    public void setStatus(ShopQueueStatus status) {
        this.status = status;
    }
}
