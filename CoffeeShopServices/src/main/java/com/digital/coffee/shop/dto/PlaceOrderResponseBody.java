package com.digital.coffee.shop.dto;

public class PlaceOrderResponseBody extends BaseResponseBody {

    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
