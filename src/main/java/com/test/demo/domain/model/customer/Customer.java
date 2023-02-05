package com.test.demo.domain.model.customer;

import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;

public class Customer {

    private final CustomerId id;;

    private final CustomerName name;

    private final CustomerEmail email;


    public Customer(CustomerId id, CustomerName name, CustomerEmail email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer(CustomerDBO customer) {
        this.id = new CustomerId(customer.getId());
        this.name = new CustomerName(customer.getName());
        this.email = new CustomerEmail(customer.getEmail());
    }

    public Customer(CustomerDTO customer) {
        this.id = new CustomerId(customer.getId());
        this.name = new CustomerName(customer.getName());
        this.email = new CustomerEmail(customer.getEmail());
    }

    public CustomerId getId() {
        return id;
    }

    public CustomerName getName() {
        return name;
    }

    public CustomerEmail getEmail() {
        return email;
    }
}
