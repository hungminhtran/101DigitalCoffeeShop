package com.digital.coffee.shop.dto.validation;

import com.digital.coffee.shop.dto.object.PlaceOrderRequestBody;
import com.digital.coffee.shop.jpa.entity.*;
import com.digital.coffee.shop.jpa.reponsitory.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceOrderRequestValidationService {
    private @Autowired MenuItemRepository menuItemRepository;
    private @Autowired OrderPromotionRepository orderPromotionRepository;
    private @Autowired PromotionRepository promotionRepository;
    private @Autowired QueueQueueItemRepository queueQueueItemRepository;
    private @Autowired QueueRepository queueRepository;
    private @Autowired ShopMenuItemRepository shopMenuItemRepository;
    private @Autowired ShopQueueRepository shopQueueRepository;
    private @Autowired ShopRepository shopRepository;

    private @Autowired CustomerRepository customerRepository;

    public Long getAnUnfilledQueueId(Long shopId) {
        List<Long> queueIds =
                shopQueueRepository.findByShopId(shopId).stream()
                        .map(ShopQueueEntity::getQueueId)
                        .collect(Collectors.toList());

        for (Long queueId : queueIds) {
            Long currentQueueSize = queueQueueItemRepository.countByQueueId(queueId);
            QueueEntity queue = queueRepository.findById(queueId).get();
            if (queue.getQueueSize() - 1 > currentQueueSize) {
                return queueId;
            }
        }
        return null;
    }

    public List<String> validate(PlaceOrderRequestBody requestBody) {
        List<String> errorMessages = new ArrayList<>();
        Optional<ShopEntity> shopEntityOptional = shopRepository.findById(requestBody.getShopId());
        if (!shopEntityOptional.isPresent()) {
            errorMessages.add("Shop doesn't exist");
            return errorMessages;
        }

        Optional<CustomerEntity> customerEntityOptional =
                customerRepository.findById(requestBody.getCustomerId());
        if (!customerEntityOptional.isPresent()) {
            errorMessages.add("Customer doesn't exist");
            return errorMessages;
        }

        ShopEntity shopEntity = shopEntityOptional.get();

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.format(date);

        try {
            if (dateFormat
                    .parse(dateFormat.format(date))
                    .after(dateFormat.parse(shopEntity.getCloseTime()))) {
                errorMessages.add("Shop has been closed");
            }
            if (dateFormat
                    .parse(dateFormat.format(date))
                    .before(dateFormat.parse(shopEntity.getOpenTime()))) {
                errorMessages.add("Shop hasn't opened");
            }
        } catch (ParseException e) {
            errorMessages.add("exception while parsing shop open/close time" + e.getMessage());
        }

        if (getAnUnfilledQueueId(shopEntity.getShopId()) == null) {
            errorMessages.add(" All queues are full");
        }

        Set<Long> shopMenuItemEntities =
                shopMenuItemRepository.findByShopId(shopEntity.getShopId()).stream()
                        .map(ShopMenuItemEntity::getMenuItemId)
                        .collect(Collectors.toSet());
        Map<Long, MenuItemEntity> menuItemEntityMap =
                StreamSupport.stream(
                                menuItemRepository
                                        .findAllById(requestBody.getMenuItemIds())
                                        .spliterator(),
                                false)
                        .collect(
                                Collectors.toMap(
                                        MenuItemEntity::getMenuItemId, Function.identity()));
        for (Long orderMenuItemId : requestBody.getMenuItemIds()) {
            MenuItemEntity menuItemEntity = menuItemEntityMap.get(orderMenuItemId);
            if (menuItemEntity == null) {
                errorMessages.add("Menu item id " + orderMenuItemId + " doesn't exist");
            } else if (!shopMenuItemEntities.contains(orderMenuItemId)) {
                errorMessages.add(
                        "Menu item " + menuItemEntity.getName() + " doesn't exist in current shop");
            }
        }

        Map<Long, PromotionEntity> promotionEntityMap =
                StreamSupport.stream(
                                promotionRepository
                                        .findAllById(requestBody.getPromotionIds())
                                        .spliterator(),
                                false)
                        .collect(
                                Collectors.toMap(
                                        PromotionEntity::getPromotionId, Function.identity()));

        for (Long promotionId : requestBody.getPromotionIds()) {
            if (orderPromotionRepository.countOrderPromotionEntityByPromotionId(promotionId) > 0) {
                errorMessages.add("Promotion " + promotionId + " already used");
            }
            PromotionEntity promotionEntity = promotionEntityMap.get(promotionId);
            if (promotionEntity == null) {
                errorMessages.add("Promotion " + promotionId + " doesn't exist");
            } else {
                if (promotionEntity.getShopId() != requestBody.getShopId()) {
                    errorMessages.add(
                            "Promotion " + promotionId + " doesn't belong to current shop");
                }
                if (promotionEntity.getCustomerId() != requestBody.getCustomerId()) {
                    errorMessages.add(
                            "Promotion " + promotionId + " doesn't belong to current customer");
                }
            }
        }

        return errorMessages;
    }
}
