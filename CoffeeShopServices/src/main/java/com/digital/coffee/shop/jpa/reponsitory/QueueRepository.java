package com.digital.coffee.shop.jpa.reponsitory;


import com.digital.coffee.shop.jpa.entity.QueueEntity;
import org.springframework.data.repository.CrudRepository;

public interface QueueRepository extends CrudRepository<QueueEntity, Long> {}
