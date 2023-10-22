package com.digital.coffee.shop.services;

import com.digital.coffee.shop.jpa.reponsitory.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {
    private @Autowired OrderRepository orderRepository;

    public Long countTotalOrder() {
        return orderRepository.count();
    }
}
