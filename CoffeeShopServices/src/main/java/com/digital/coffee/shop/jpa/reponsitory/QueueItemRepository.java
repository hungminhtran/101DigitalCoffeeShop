package com.digital.coffee.shop.jpa.reponsitory;


import com.digital.coffee.shop.jpa.entity.QueueItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface QueueItemRepository extends CrudRepository<QueueItemEntity, Long> {}
