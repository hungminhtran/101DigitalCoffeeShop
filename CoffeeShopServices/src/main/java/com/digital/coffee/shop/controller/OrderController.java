package com.digital.coffee.shop.controller;

import com.digital.coffee.shop.dto.object.PlaceOrderRequestBody;
import com.digital.coffee.shop.dto.object.PlaceOrderResponseBody;
import com.digital.coffee.shop.services.OrderService;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired private OrderService orderService;

    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public PlaceOrderResponseBody placeOrder(
            @RequestBody PlaceOrderRequestBody placeOrderRequestBody) {

        PlaceOrderResponseBody responseBody = orderService.placeOrder(placeOrderRequestBody);
        if (responseBody == null) {
            responseBody = new PlaceOrderResponseBody();
            responseBody.setStatusCode(HttpStatus.CONFLICT.value());
            responseBody.setMessages(
                    Arrays.asList(
                            "Could not place new order for current shop due to concurrency data update"));
        }
        return responseBody;
    }
}
