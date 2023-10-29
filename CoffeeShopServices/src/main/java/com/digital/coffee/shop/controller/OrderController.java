package com.digital.coffee.shop.controller;

import com.digital.coffee.shop.dto.PlaceOrderRequestBody;
import com.digital.coffee.shop.dto.PlaceOrderResponseBody;
import com.digital.coffee.shop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired private OrderService orderService;

    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public PlaceOrderResponseBody placeOrder(
            @RequestBody PlaceOrderRequestBody placeOrderRequestBody) {
        return orderService.placeOrder(placeOrderRequestBody);
    }
}
