package com.test.demo.domain.model.customer.gateway;

import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.dto.CustomerDTO;

import java.util.List;


public interface CustomerRepository {

    public String saveCustomer(Customer customer);
    public List<Customer> getCustomers();
}
