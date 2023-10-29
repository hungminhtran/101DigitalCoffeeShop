package com.digital.coffee.shop.controller;

import com.digital.coffee.shop.dto.object.PlaceOrderRequestBody;
import com.digital.coffee.shop.dto.object.PlaceOrderResponseBody;
import com.digital.coffee.shop.services.OrderService;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class OrderController {
    @Autowired private OrderService orderService;

    @PostMapping(value = "/order", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public PlaceOrderResponseBody placeOrder(
            @RequestBody PlaceOrderRequestBody placeOrderRequestBody,
            HttpServletResponse response) {
        PlaceOrderResponseBody responseBody = orderService.placeOrder(placeOrderRequestBody);
        response.setStatus(responseBody.getStatusCode());
        return responseBody;
    }
}
