package com.digital.coffee.shop.constants;

public enum MenuItemStatus {
    AVAILABLE("Available", 1),
    UNAVAILABLE("Unavailable", 2);

    private String statusName;
    private Integer statusCode;

    private MenuItemStatus(String name, Integer code) {
        statusCode = code;
        statusName = name;
    }
}
