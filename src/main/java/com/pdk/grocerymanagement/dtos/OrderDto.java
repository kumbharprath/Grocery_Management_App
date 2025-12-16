package com.pdk.grocerymanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private Long id;
    private Long customerId;
    private List<Long> groceryItemIds;
    private LocalDate orderDate;
    private BigDecimal totalPrice;
}

