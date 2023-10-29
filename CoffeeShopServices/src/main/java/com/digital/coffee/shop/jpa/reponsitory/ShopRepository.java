package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {}
