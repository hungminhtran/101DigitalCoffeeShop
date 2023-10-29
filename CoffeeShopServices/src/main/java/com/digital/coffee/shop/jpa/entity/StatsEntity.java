package com.digital.coffee.shop.jpa.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatsEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statsId;

    private Long shopId;
    private Long menuItemId;
    private Long totalPreparingTime;
    private Long totalCompleteOrders;

    public Long getStatsId() {
        return statsId;
    }

    public void setStatsId(Long statsId) {
        this.statsId = statsId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Long getTotalPreparingTime() {
        return totalPreparingTime;
    }

    public void setTotalPreparingTime(Long totalPreparingTime) {
        this.totalPreparingTime = totalPreparingTime;
    }

    public Long getTotalCompleteOrders() {
        return totalCompleteOrders;
    }

    public void setTotalCompleteOrders(Long totalCompleteOrders) {
        this.totalCompleteOrders = totalCompleteOrders;
    }
}
