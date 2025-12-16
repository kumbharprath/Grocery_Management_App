package com.pdk.grocerymanagement.mapper;


import com.pdk.grocerymanagement.dtos.GroceryItemDto;
import com.pdk.grocerymanagement.entities.GroceryItemEntity;

public class GroceryItemMapper {

    public static GroceryItemDto mapToDto(GroceryItemEntity groceryItemEntity) {
        if (groceryItemEntity == null) {
            return null;
        }

        return GroceryItemDto.builder()
                .id(groceryItemEntity.getId())
                .name(groceryItemEntity.getName())
                .category(groceryItemEntity.getCategory())
                .price(groceryItemEntity.getPrice())
                .quantity(groceryItemEntity.getQuantity())
                .build();
    }

    public static GroceryItemEntity mapToEntity(GroceryItemDto groceryItemDto) {
        if (groceryItemDto == null) {
            return null;
        }

        return GroceryItemEntity.builder()
                .id(groceryItemDto.getId())
                .name(groceryItemDto.getName())
                .category(groceryItemDto.getCategory())
                .price(groceryItemDto.getPrice())
                .quantity(groceryItemDto.getQuantity())
                .build();
    }

    public static void updateEntity(GroceryItemDto dto, GroceryItemEntity groceryItem) {
        if (dto == null || groceryItem == null) {
            return;
        }

        groceryItem.setName(dto.getName());
        groceryItem.setCategory(dto.getCategory());
        groceryItem.setPrice(dto.getPrice());
        groceryItem.setQuantity(dto.getQuantity());
    }
}
