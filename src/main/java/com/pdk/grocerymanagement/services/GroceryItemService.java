package com.pdk.grocerymanagement.services;

import com.pdk.grocerymanagement.dtos.GroceryItemDto;

import java.util.List;

public interface GroceryItemService {

    GroceryItemDto createGroceryItem(GroceryItemDto groceryItemDto);

    GroceryItemDto getGroceryItemById(Long id);

    List<GroceryItemDto> getAllGroceryItems();

    GroceryItemDto updateGroceryItem(Long id, GroceryItemDto groceryItemDto);

    void deleteGroceryItem(Long id);
}