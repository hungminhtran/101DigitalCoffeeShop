package com.digital.coffee.shop.jpa.reponsitory;


import com.digital.coffee.shop.jpa.entity.ShopQueueEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopQueueRepository extends CrudRepository<ShopQueueEntity, Long> {}
