package com.pdk.grocerymanagement.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroceryItemDto {

    private Long id;
    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

}
