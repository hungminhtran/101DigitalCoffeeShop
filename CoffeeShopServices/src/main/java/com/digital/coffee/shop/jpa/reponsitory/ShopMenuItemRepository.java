package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.ShopMenuItemEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ShopMenuItemRepository extends CrudRepository<ShopMenuItemEntity, Long> {
    public List<ShopMenuItemEntity> findByShopId(Long shopId);
}
