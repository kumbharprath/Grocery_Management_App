package com.pdk.grocerymanagement.repositories;

import com.pdk.grocerymanagement.entities.GroceryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItemEntity, Long> {
}
