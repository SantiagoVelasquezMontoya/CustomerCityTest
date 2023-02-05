package com.test.demo.infrastructure.adapters.jpa.customer.dbo;

import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.CustomerEmail;
import com.test.demo.domain.model.customer.CustomerId;
import com.test.demo.domain.model.customer.CustomerName;
import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name  = "customer")
public class CustomerDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;

    @ManyToMany
//    @JoinTable(
//            name = "city",
//            joinColumns = @JoinColumn(name = "customer_id"))
    List<CityDBO> city;


    public CustomerDBO(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerDBO(CustomerDTO customer) {
        this.id = customer.getId();
        this.name = customer.getName();
        this.email = customer.getEmail();
    }

    public CustomerDBO(Customer customer) {
        this.id = customer.getId().getValue();
        this.name = customer.getName().getValue();
        this.email = customer.getEmail().getValue();
        }



    public static Customer toCustomer(CustomerDBO customer){
        return new Customer(
                new CustomerId(customer.getId()),
                new CustomerName(customer.getName()),
                new CustomerEmail(customer.getEmail())
        );
    }
}
