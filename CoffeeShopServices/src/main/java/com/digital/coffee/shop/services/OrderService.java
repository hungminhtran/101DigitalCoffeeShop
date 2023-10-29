package com.digital.coffee.shop.services;

import com.digital.coffee.shop.constants.OrderStatus;
import com.digital.coffee.shop.constants.PaymentStatus;
import com.digital.coffee.shop.dto.object.PlaceOrderRequestBody;
import com.digital.coffee.shop.dto.object.PlaceOrderResponseBody;
import com.digital.coffee.shop.dto.validation.PlaceOrderRequestValidationService;
import com.digital.coffee.shop.jpa.entity.*;
import com.digital.coffee.shop.jpa.reponsitory.*;
import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private @Autowired PlaceOrderRequestValidationService placeOrderRequestValidationService;
    private @Autowired OrderRepository orderRepository;
    private @Autowired MenuItemRepository menuItemRepository;
    private @Autowired OrderMenuItemRepository orderMenuItemRepository;
    private @Autowired OrderPromotionRepository orderPromotionRepository;
    private @Autowired PromotionRepository promotionRepository;
    private @Autowired QueueItemRepository queueItemRepository;
    private @Autowired QueueQueueItemRepository queueQueueItemRepository;
    private @Autowired PaymentRepository paymentRepository;
    private @Autowired StatsRepository statsRepository;

    /* PostGreSQL Isolation.REPEATABLE_READ can prevent phantom issue, which is good enough in this case*/
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public PlaceOrderResponseBody placeOrder(PlaceOrderRequestBody requestBody) {
        List<String> errorMessages = placeOrderRequestValidationService.validate(requestBody);
        if (errorMessages.size() > 0) {
            PlaceOrderResponseBody responseBody = new PlaceOrderResponseBody();
            responseBody.setStatusCode(HttpStatus.BAD_REQUEST.value());
            responseBody.setMessages(errorMessages);
            return responseBody;
        }

        // order
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setShopId(requestBody.getShopId());
        orderEntity.setCustomerId(requestBody.getCustomerId());
        orderEntity.setOrderStatus(OrderStatus.CREATED);
        orderEntity.setCreatedAt(new Date());
        orderRepository.save(orderEntity);
        // order menu item + stats
        Long merchandiseSubtotal = 0L;
        {
            Iterable<MenuItemEntity> menuItemEntities =
                    menuItemRepository.findAllById(requestBody.getMenuItemIds());
            List<OrderMenuItemEntity> orderMenuItemEntityList = new ArrayList<>();
            List<StatsEntity> statsEntityList = new ArrayList<>();
            for (MenuItemEntity menuItemEntity : menuItemEntities) {
                OrderMenuItemEntity orderMenuItemEntity = new OrderMenuItemEntity();
                orderMenuItemEntity.setOrderId(orderEntity.getOrderId());
                orderMenuItemEntity.setMenuItemId(menuItemEntity.getMenuItemId());
                orderMenuItemEntityList.add(orderMenuItemEntity);
                merchandiseSubtotal += menuItemEntity.getPrice();
                if (statsRepository.countStatsEntityByShopIdAndMenuItemId(
                                requestBody.getShopId(), menuItemEntity.getMenuItemId())
                        == 0) {
                    StatsEntity statsEntity = new StatsEntity();
                    statsEntity.setShopId(requestBody.getShopId());
                    statsEntity.setMenuItemId(menuItemEntity.getMenuItemId());
                    statsEntityList.add(statsEntity);
                }
            }
            orderMenuItemRepository.saveAll(orderMenuItemEntityList);
            statsRepository.saveAll(statsEntityList);
        }

        // order promo
        Long promotionSubtotal = 0L;
        {
            Iterable<PromotionEntity> promotionEntities =
                    promotionRepository.findAllById(requestBody.getPromotionIds());
            List<OrderPromotionEntity> orderPromotionEntityList = new ArrayList<>();
            for (PromotionEntity promotionEntity : promotionEntities) {
                OrderPromotionEntity orderMenuItemEntity = new OrderPromotionEntity();
                orderMenuItemEntity.setOrderId(orderEntity.getOrderId());
                orderMenuItemEntity.setPromotionId(promotionEntity.getPromotionId());
                orderPromotionEntityList.add(orderMenuItemEntity);
                promotionSubtotal += promotionEntity.getPromotionValue();
            }
            orderPromotionRepository.saveAll(orderPromotionEntityList);
        }
        // payment
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setPaymentStatus(PaymentStatus.PENDING);
        paymentEntity.setMerchandiseSubTotal(merchandiseSubtotal);
        paymentEntity.setPromotionSubtotal(promotionSubtotal);
        paymentRepository.save(paymentEntity);
        orderEntity.setPaymentId(paymentEntity.getPaymentId());
        orderRepository.save(orderEntity);
        // queue item
        QueueItemEntity queueItemEntity = new QueueItemEntity();
        queueItemEntity.setOrderId(orderEntity.getOrderId());
        queueItemRepository.save(queueItemEntity);
        // queue and queue item
        Long unfilledQueueId =
                placeOrderRequestValidationService.getAnUnfilledQueueId(requestBody.getShopId());
        QueueQueueItemEntity queueQueueItemEntity = new QueueQueueItemEntity();
        queueQueueItemEntity.setQueueId(unfilledQueueId);
        queueQueueItemEntity.setQueueItemId(queueItemEntity.getQueueItemId());
        queueQueueItemRepository.save(queueQueueItemEntity);
        PlaceOrderResponseBody responseBody = new PlaceOrderResponseBody();
        responseBody.setStatusCode(HttpStatus.OK.value());
        responseBody.setOrderId(orderEntity.getOrderId());
        responseBody.setPaymentId(paymentEntity.getPaymentId());
        return responseBody;
    }
}
