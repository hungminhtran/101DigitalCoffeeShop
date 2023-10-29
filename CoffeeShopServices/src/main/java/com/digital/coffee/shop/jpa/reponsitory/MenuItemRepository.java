package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.MenuItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends CrudRepository<MenuItemEntity, Long> {}
