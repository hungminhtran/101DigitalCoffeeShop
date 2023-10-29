package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.QueueQueueItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface QueueQueueItemRepository extends CrudRepository<QueueQueueItemEntity, Long> {
    public Long countByQueueId(Long queueId);
}
