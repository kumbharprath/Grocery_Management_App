package com.pdk.grocerymanagement.services;

import com.pdk.grocerymanagement.dtos.OrderDto;

import java.util.List;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long id);

    List<OrderDto> getAllOrders();

    OrderDto updateOrder(Long id, OrderDto orderDto);

    void deleteOrder(Long id);
}
