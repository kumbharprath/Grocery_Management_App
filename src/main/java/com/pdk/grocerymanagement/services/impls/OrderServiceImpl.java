package com.pdk.grocerymanagement.services.impls;

import com.pdk.grocerymanagement.dtos.OrderDto;
import com.pdk.grocerymanagement.entities.CustomerEntity;
import com.pdk.grocerymanagement.entities.GroceryItemEntity;
import com.pdk.grocerymanagement.entities.OrderEntity;
import com.pdk.grocerymanagement.mapper.OrderMapper;
import com.pdk.grocerymanagement.repositories.CustomerRepository;
import com.pdk.grocerymanagement.repositories.GroceryItemRepository;
import com.pdk.grocerymanagement.repositories.OrderRepository;
import com.pdk.grocerymanagement.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final GroceryItemRepository groceryItemRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto dto) {
        CustomerEntity customer =
                customerRepository.findById(dto.getCustomerId()).orElseThrow();

        List<GroceryItemEntity> groceryItems =
                groceryItemRepository.findAllById(dto.getGroceryItemIds());

        OrderEntity order =
                orderMapper.mapToEntity(dto, customer, groceryItems);

        return orderMapper.mapToDto(orderRepository.save(order));
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow();
        return orderMapper.mapToDto(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto dto) {
        OrderEntity order = orderRepository.findById(id).orElseThrow();

        CustomerEntity customer =
                customerRepository.findById(dto.getCustomerId()).orElseThrow();

        List<GroceryItemEntity> groceryItems =
                groceryItemRepository.findAllById(dto.getGroceryItemIds());

        orderMapper.updateEntity(order, dto, customer, groceryItems);

        return orderMapper.mapToDto(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
