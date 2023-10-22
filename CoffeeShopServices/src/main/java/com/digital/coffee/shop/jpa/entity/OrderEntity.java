package com.digital.coffee.shop.jpa.entity;

import com.digital.coffee.shop.constants.OrderStatus;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderEntity {
    @Id private Long orderId;
    private Long shopId;
    private Long userId;
    private Long paymentId;
    private OrderStatus orderStatus;
    private Date createdAt;
}
