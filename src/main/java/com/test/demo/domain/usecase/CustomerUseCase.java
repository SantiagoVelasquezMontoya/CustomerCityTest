package com.test.demo.domain.usecase;

import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.domain.model.customer.gateway.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerUseCase {

    private CustomerRepository customerRepository;

    public CustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public String saveCustomer(CustomerDTO customerDTO){
        return customerRepository.saveCustomer(CustomerDTO.toCustomer(customerDTO));
    }

    public List<CustomerDTO> getCustomers(){
        List<Customer> customerList = customerRepository.getCustomers();
        return customerList.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }
}
