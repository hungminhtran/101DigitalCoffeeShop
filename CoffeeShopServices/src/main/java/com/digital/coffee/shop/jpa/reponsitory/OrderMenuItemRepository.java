package com.digital.coffee.shop.jpa.reponsitory;


import com.digital.coffee.shop.jpa.entity.OrderMenuItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderMenuItemRepository extends CrudRepository<OrderMenuItemEntity, Long> {}
