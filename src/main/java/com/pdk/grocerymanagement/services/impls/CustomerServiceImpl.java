package com.pdk.grocerymanagement.services.impls;

import com.pdk.grocerymanagement.dtos.CustomerDto;
import com.pdk.grocerymanagement.entities.CustomerEntity;
import com.pdk.grocerymanagement.mapper.CustomerMapper;
import com.pdk.grocerymanagement.repositories.CustomerRepository;
import com.pdk.grocerymanagement.services.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.mapToCustomerEntity(customerDto);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                                        .orElseThrow(() ->
                                                new RuntimeException("Customer not found with id: " + id)
                                        );
        return CustomerMapper.mapToCustomerDto(customerEntity);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::mapToCustomerDto)
                .toList();
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        CustomerEntity existingCustomer = customerRepository.findById(id)
                                        .orElseThrow(() ->
                                                new RuntimeException("Customer not found with id: " + id)
                                        );
        CustomerMapper.updateEntity(customerDto, existingCustomer);
        CustomerEntity updatedCustomer = customerRepository.save(existingCustomer);
        return CustomerMapper.mapToCustomerDto(updatedCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        CustomerEntity existingCustomer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Customer not found with id: " + id)
                );
        customerRepository.delete(existingCustomer);
    }
}
