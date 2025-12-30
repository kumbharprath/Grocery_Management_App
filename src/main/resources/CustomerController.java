package com.pdk.grocerymanagement.controllers;

import com.pdk.grocerymanagement.dtos.CustomerDto;
import com.pdk.grocerymanagement.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CustomerController.GMA_API_ENDPOINT+CustomerController.CUSTOMERS_API)
@RequiredArgsConstructor
public class CustomerController {
    public static final String GMA_API_ENDPOINT = "/api/v1";
    public static final String CUSTOMERS_API = "/customers";

    private final CustomerService customerService;


    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {

        return new ResponseEntity<CustomerDto>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {

        CustomerDto customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {

        List<CustomerDto> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @PathVariable Long id,
            @RequestBody CustomerDto customerDto) {

        CustomerDto updatedCustomer = customerService.updateCustomer(id, customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
