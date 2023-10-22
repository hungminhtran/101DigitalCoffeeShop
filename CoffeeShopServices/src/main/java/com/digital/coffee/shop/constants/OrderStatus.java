package com.digital.coffee.shop.constants;

public enum OrderStatus {
    CREATED("created", 1),
    PREPARING("preparing", 2),
    COMPLETE("complete", 3),
    CANCEL("cancel", 4);

    private String statusName;
    private Integer statusCode;

    private OrderStatus(String name, Integer code) {
        statusCode = code;
        statusName = name;
    }
}
