package com.pdk.grocerymanagement.controllers;


import com.pdk.grocerymanagement.dtos.GroceryItemDto;
import com.pdk.grocerymanagement.services.GroceryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(GroceryItemController.GMA_API_ENDPOINT+GroceryItemController.GROCERY_ITEMS_API)
@RequiredArgsConstructor
public class GroceryItemController {

    public static final String GMA_API_ENDPOINT = "/api/v1";
    public static final String GROCERY_ITEMS_API = "/groceryItems";

    private final GroceryItemService groceryItemService;

    @PostMapping
    public ResponseEntity<GroceryItemDto> addGroceryItem(@RequestBody GroceryItemDto groceryItemDto) {

        return new ResponseEntity<GroceryItemDto>(groceryItemService.createGroceryItem(groceryItemDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItemDto> getGroceryItemById(@PathVariable Long id) {

        GroceryItemDto groceryItem = groceryItemService.getGroceryItemById(id);
        return ResponseEntity.ok(groceryItem);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItemDto>> getAllGroceryItems() {

        List<GroceryItemDto> groceryItems = groceryItemService.getAllGroceryItems();
        return ResponseEntity.ok(groceryItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItemDto> updateGroceryItem(
            @PathVariable Long id,
            @RequestBody GroceryItemDto groceryItemDto) {

        GroceryItemDto updatedGroceryItem = groceryItemService.updateGroceryItem(id, groceryItemDto);
        return ResponseEntity.ok(updatedGroceryItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        groceryItemService.deleteGroceryItem(id);
        return ResponseEntity.noContent().build();
    }
}
