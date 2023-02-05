package com.test.demo.domain.model.city.gateway;

import com.test.demo.domain.model.city.City;

import java.util.List;

public interface CityRepository {

    public String saveCity(City city);

    public List<City> getCities();
}
