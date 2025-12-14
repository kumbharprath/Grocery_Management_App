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
}
