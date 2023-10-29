package com.digital.coffee.shop.constants;

public enum OrderStatus {
    CREATED("Created", 1),
    PREPARING("Preparing", 2),
    COMPLETE("Complete", 3),
    CANCEL("Cancel", 4);

    private String statusName;
    private Integer statusCode;

    private OrderStatus(String name, Integer code) {
        statusCode = code;
        statusName = name;
    }
}
