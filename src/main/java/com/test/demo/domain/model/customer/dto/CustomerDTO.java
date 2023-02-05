package com.test.demo.domain.model.customer.dto;

import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.CustomerEmail;
import com.test.demo.domain.model.customer.CustomerId;
import com.test.demo.domain.model.customer.CustomerName;
import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;

public class CustomerDTO {

    private Integer id;
    private String name;
    private String email;


    public CustomerDTO(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(CustomerDBO customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId().getValue();
        this.name = customer.getName().getValue();
        this.email = customer.getEmail().getValue();
    }
    public static Customer toCustomer(CustomerDTO customer){
        return new Customer(
                new CustomerId(customer.getId()),
                new CustomerName(customer.getName()),
                new CustomerEmail(customer.getEmail())
        );
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
