package com.pdk.grocerymanagement.services.impls;

import com.pdk.grocerymanagement.dtos.GroceryItemDto;
import com.pdk.grocerymanagement.entities.GroceryItemEntity;
import com.pdk.grocerymanagement.mapper.CustomerMapper;
import com.pdk.grocerymanagement.mapper.GroceryItemMapper;
import com.pdk.grocerymanagement.repositories.GroceryItemRepository;
import com.pdk.grocerymanagement.services.GroceryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroceryItemServiceImpl implements GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Override
    public GroceryItemDto createGroceryItem(GroceryItemDto dto) {
        GroceryItemEntity entity = GroceryItemMapper.mapToEntity(dto);
        GroceryItemEntity saved = groceryItemRepository.save(entity);
        return GroceryItemMapper.mapToDto(saved);
    }

    @Override
    public GroceryItemDto getGroceryItemById(Long id) {
        GroceryItemEntity entity = groceryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GroceryItem not found with id: " + id));
        return GroceryItemMapper.mapToDto(entity);
    }

    @Override
    public List<GroceryItemDto> getAllGroceryItems() {
        return groceryItemRepository.findAll()
                .stream()
                .map(GroceryItemMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public GroceryItemDto updateGroceryItem(Long id, GroceryItemDto dto) {
        GroceryItemEntity entity = groceryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("GroceryItem not found with id: " + id));

        GroceryItemMapper.updateEntity(dto, entity);

        GroceryItemEntity updated = groceryItemRepository.save(entity);
        return GroceryItemMapper.mapToDto(updated);
    }

    @Override
    public void deleteGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }

}
