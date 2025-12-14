package com.pdk.grocerymanagement.contollers;

import com.pdk.grocerymanagement.dtos.CustomerDto;
import com.pdk.grocerymanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CustomerController.CUSTOMER_API_ENDPOINT+CustomerController.CUSTOMERS_API)
public class CustomerController {
    public static final String CUSTOMER_API_ENDPOINT = "/api/v1";
    public static final String CUSTOMERS_API = "/customers";

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<CustomerDto>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }
}
