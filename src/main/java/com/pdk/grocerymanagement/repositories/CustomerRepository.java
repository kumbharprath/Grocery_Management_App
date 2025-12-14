package com.pdk.grocerymanagement.repositories;

import com.pdk.grocerymanagement.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
