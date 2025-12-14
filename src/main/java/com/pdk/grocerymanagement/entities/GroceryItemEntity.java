package com.pdk.grocerymanagement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "grocery_items")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroceryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private BigDecimal price;
    private int quantity;

    @ManyToMany(mappedBy = "groceryItems")
    private List<OrderEntity> orders;
}
