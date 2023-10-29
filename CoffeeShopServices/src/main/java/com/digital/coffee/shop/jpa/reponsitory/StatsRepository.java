package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.StatsEntity;
import org.springframework.data.repository.CrudRepository;

public interface StatsRepository extends CrudRepository<StatsEntity, Long> {
    public Long countStatsEntityByShopIdAndMenuItemId(Long shopId, Long menuItemId);
}
