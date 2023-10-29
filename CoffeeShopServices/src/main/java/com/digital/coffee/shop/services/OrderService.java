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

    // PostGreSQL  Isolation.REPEATABLE_READ can prevent phantom issue, which is good enough in this
    // case
    // we don't need Isolation.SERIALIZABLE

    private boolean placeOrderRequestValidation(PlaceOrderRequestBody requestBody) {

        return true;
    }

    @Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.REPEATABLE_READ)
    public PlaceOrderResponseBody placeOrder(PlaceOrderRequestBody requestBody) {

        return null;
    }
}
