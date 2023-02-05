package com.test.demo.domain.model.city.dto;


import com.test.demo.domain.model.city.City;
import com.test.demo.domain.model.city.CityId;
import com.test.demo.domain.model.city.CityName;
import com.test.demo.domain.model.city.CityTemperature;
import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;
import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;

import java.util.List;
import java.util.stream.Collectors;

public class CityDTO {

    private Integer id;
    private String name;
    private Integer temperature;

    List<Customer> customer;

    public CityDTO(Integer id, String name, Integer temperature) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
    }

    public CityDTO() {
    }

    public CityDTO(CityDBO city) {
        this.id = city.getId();
        this.name = city.getName();
        this.temperature = city.getTemperature();
    }

    public CityDTO(Integer id, String name, Integer temperature, List<Customer> customer) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
        this.customer = customer;
    }

    public CityDTO(City city) {
        this.id = city.getId().getValue();
        this.name = city.getName().getValue();
        this.temperature = city.getTemperature().getValue();
        this.customer = city.getCustomer();
    }

    public static City toCity(CityDTO city){
        return new City(
                new CityId(city.getId()),
                new CityName(city.getName()),
                new CityTemperature(city.getTemperature()),
                city.getCustomer()
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

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
