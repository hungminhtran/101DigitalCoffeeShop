package com.digital.coffee.shop.controller;

import com.digital.coffee.shop.services.OrderServices;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired private OrderServices orderServices;

    @GetMapping(value = "/total-orders", produces = "application/json")
    public String healthCheck(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
        return orderServices.countTotalOrder().toString();
    }
}
