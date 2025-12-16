package com.pdk.grocerymanagement.mapper;

import com.pdk.grocerymanagement.dtos.OrderDto;
import com.pdk.grocerymanagement.entities.CustomerEntity;
import com.pdk.grocerymanagement.entities.GroceryItemEntity;
import com.pdk.grocerymanagement.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDto mapToDto(OrderEntity entity) {
        return OrderDto.builder()
                .id(entity.getId())
                .customerId(entity.getCustomerEntity().getId())
                .groceryItemIds(entity.getGroceryItems()
                        .stream()
                        .map(GroceryItemEntity::getId)
                        .collect(Collectors.toList()))
                .orderDate(entity.getOrderDate())
                .totalPrice(entity.getTotalPrice())
                .build();
    }

    public OrderEntity mapToEntity(
            OrderDto dto,
            CustomerEntity customer,
            List<GroceryItemEntity> groceryItems
    ) {
        return OrderEntity.builder()
                .customerEntity(customer)
                .groceryItems(groceryItems)
                .orderDate(dto.getOrderDate())
                .totalPrice(dto.getTotalPrice())
                .build();
    }

    public void updateEntity(
            OrderEntity order,
            OrderDto dto,
            CustomerEntity customer,
            List<GroceryItemEntity> groceryItems
    ) {
        order.setCustomerEntity(customer);
        order.setGroceryItems(groceryItems);
        order.setOrderDate(dto.getOrderDate());
        order.setTotalPrice(dto.getTotalPrice());
    }
}
