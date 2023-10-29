package com.digital.coffee.shop.services;

import com.digital.coffee.shop.dto.PlaceOrderRequestBody;
import com.digital.coffee.shop.dto.PlaceOrderResponseBody;
import com.digital.coffee.shop.jpa.reponsitory.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private @Autowired OrderRepository orderRepository;

    private boolean placeOrderRequestValidation(PlaceOrderRequestBody requestBody) {
        /*
        open/close time 15 mins
        shop has > 0 queue
        one of shop'queue max size > 0
        one of shope's queu size < shop's queue max size
        menu item in orders belong to shop and available
        promotion is not use and valid and belong to shop, and belong to current user
        */

        return true;
    }

    // PostGreSQL  Isolation.REPEATABLE_READ can prevent phantom issue, which is good enough in this
    // case
    // we don't need Isolation.SERIALIZABLE
    @Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.REPEATABLE_READ)
    public PlaceOrderResponseBody placeOrder(PlaceOrderRequestBody requestBody) {

        return null;
    }
}
