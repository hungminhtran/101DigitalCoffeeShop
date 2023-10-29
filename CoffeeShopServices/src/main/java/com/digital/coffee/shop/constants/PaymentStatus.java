package com.digital.coffee.shop.constants;

public enum PaymentStatus {
    CREATED("Paid", 1),
    PREPARING("Pending", 2);

    private String statusName;
    private Integer statusCode;

    private PaymentStatus(String name, Integer code) {
        statusCode = code;
        statusName = name;
    }
}
