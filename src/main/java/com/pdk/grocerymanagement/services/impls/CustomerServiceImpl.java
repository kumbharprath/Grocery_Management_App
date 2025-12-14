package com.pdk.grocerymanagement.services.impls;

import com.pdk.grocerymanagement.dtos.CustomerDto;
import com.pdk.grocerymanagement.entities.CustomerEntity;
import com.pdk.grocerymanagement.mapper.CustomerMapper;
import com.pdk.grocerymanagement.repositories.CustomerRepository;
import com.pdk.grocerymanagement.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = CustomerMapper.mapToCustomerEntity(customerDto);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return List.of();
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDTO) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }
}
