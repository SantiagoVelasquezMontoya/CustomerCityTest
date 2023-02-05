package com.test.demo.domain.model.city.dto;


import com.test.demo.domain.model.city.City;
import com.test.demo.domain.model.city.CityId;
import com.test.demo.domain.model.city.CityName;
import com.test.demo.domain.model.city.CityTemperature;
import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;

public class CityDTO {

    private Integer id;
    private String name;
    private Integer temperature;

    public CityDTO(Integer id, String name, Integer temperature) {
        this.id = id;
        this.name = name;
        this.temperature = temperature;
    }

    public CityDTO(CityDBO city) {
        this.id = city.getId();
        this.name = city.getName();
        this.temperature = city.getTemperature();
    }

    public CityDTO(City city) {
        this.id = city.getId().getValue();
        this.name = city.getName().getValue();
        this.temperature = city.getTemperature().getValue();
    }

    public static City toCity(CityDTO city){
        return new City(
                new CityId(city.getId()),
                new CityName(city.getName()),
                new CityTemperature(city.getTemperature())
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
}
