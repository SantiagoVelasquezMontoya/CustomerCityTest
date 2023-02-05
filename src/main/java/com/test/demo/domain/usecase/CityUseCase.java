package com.test.demo.domain.usecase;

import com.test.demo.domain.model.city.City;
import com.test.demo.domain.model.city.dto.CityDTO;
import com.test.demo.domain.model.city.gateway.CityRepository;
import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.infrastructure.adapters.jpa.city.CityRepositoryAdapter;
import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;

import java.util.List;
import java.util.stream.Collectors;

public class CityUseCase {

    private CityRepository cityRepository;

    public CityUseCase(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String saveCity(CityDTO city){
        return cityRepository.saveCity(CityDTO.toCity(city));
    }

    public List<CityDTO> getCities (){
        List<City> cityList = cityRepository.getCities();
        return cityList.stream().map(CityDTO::new).collect(Collectors.toList());
    }
}
