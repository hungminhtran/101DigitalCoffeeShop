package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {}
