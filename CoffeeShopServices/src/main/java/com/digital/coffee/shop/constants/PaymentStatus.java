package com.digital.coffee.shop.constants;

public enum PaymentStatus {
    PAID("Paid", 1),
    PENDING("Pending", 2);

    private String statusName;
    private Integer statusCode;

    private PaymentStatus(String name, Integer code) {
        statusCode = code;
        statusName = name;
    }
}
