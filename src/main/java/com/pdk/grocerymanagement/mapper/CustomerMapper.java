package com.pdk.grocerymanagement.mapper;

import com.pdk.grocerymanagement.dtos.CustomerDto;
import com.pdk.grocerymanagement.entities.CustomerEntity;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(CustomerEntity customerEntity) {
        if (customerEntity == null) {
            return null;
        }

        return CustomerDto.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .email(customerEntity.getEmail())
                .address(customerEntity.getAddress())
                .phone(customerEntity.getPhone())
                .build();
    }

    public static CustomerEntity mapToCustomerEntity(CustomerDto customerDto) {
        if (customerDto == null) {
            return null;
        }

        return CustomerEntity.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .address(customerDto.getAddress())
                .phone(customerDto.getPhone())
                .build();
    }

    public static void updateEntity(CustomerDto dto, CustomerEntity customer) {
        if (dto == null || customer == null) {
            return;
        }

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(dto.getAddress());
        customer.setPhone(dto.getPhone());
    }
}
