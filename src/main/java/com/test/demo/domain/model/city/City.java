package com.test.demo.domain.model.city;

import com.test.demo.domain.model.city.dto.CityDTO;
import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.CustomerEmail;
import com.test.demo.domain.model.customer.CustomerId;
import com.test.demo.domain.model.customer.CustomerName;
import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;
import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;

import java.util.List;

public class City {

    private final CityId id;
    private final CityName name;
    private final CityTemperature temperature;
    List<Customer> customer;


    public City(CityDTO city) {
        this.id = new CityId(city.getId());
        this.name = new CityName(city.getName());
        this.temperature = new CityTemperature(city.getTemperature());
    }

    public City(CityId id, CityName name, CityTemperature temperature, List<Customer> customer) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
        this.customer = customer;
    }

    public City(CityDBO city) {
        this.id = new CityId(city.getId());
        this.name = new CityName(city.getName());
        this.temperature = new CityTemperature(city.getTemperature());
    }

    public CityId getId() {
        return id;
    }

    public CityName getName() {
        return name;
    }

    public CityTemperature getTemperature() {
        return temperature;
    }

    public List<Customer> getCustomer() {
        return customer;
    }
}
