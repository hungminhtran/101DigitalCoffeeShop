package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.OrderPromotionEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderPromotionRepository extends CrudRepository<OrderPromotionEntity, Long> {
    public Long countOrderPromotionEntityByPromotionId(Long promotionId);
}
