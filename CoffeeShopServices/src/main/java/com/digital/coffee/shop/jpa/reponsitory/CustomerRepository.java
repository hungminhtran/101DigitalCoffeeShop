package com.digital.coffee.shop.jpa.reponsitory;

import com.digital.coffee.shop.jpa.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {}
