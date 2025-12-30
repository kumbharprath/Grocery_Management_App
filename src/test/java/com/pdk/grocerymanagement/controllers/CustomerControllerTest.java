//package com.pdk.grocerymanagement.controllers;
//
////import com.fasterxml.jackson.databind.ObjectMapper;
//import tools.jackson.databind.ObjectMapper;
//
//import com.pdk.grocerymanagement.dtos.CustomerDto;
//import com.pdk.grocerymanagement.services.CustomerService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(CustomerController.class)
//class CustomerControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @MockBean
//    private CustomerService customerService;
//
//    @Test
//    void shouldCreateCustomer() throws Exception {
//        CustomerDto responseDto = new CustomerDto(
//                1L,
//                "John",
//                "john@gmail.com",
//                "Pune",
//                "9999999999"
//        );
//
//        when(customerService.createCustomer(any(CustomerDto.class)))
//                .thenReturn(responseDto);
//
//        mockMvc.perform(post("/api/v1/customers")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(responseDto)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.id").value(1));
//    }
//
//    @Test
//    void shouldGetAllCustomers() throws Exception {
//        when(customerService.getAllCustomers())
//                .thenReturn(List.of());
//
//        mockMvc.perform(get("/api/v1/customers")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isArray());
//    }
//}
