package com.test.demo.infrastructure.adapters.jpa.city;


import com.test.demo.domain.model.city.City;
import com.test.demo.domain.model.city.gateway.CityRepository;
import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;
import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CityRepositoryAdapter implements CityRepository {

    private final ICityRepositoryAdapter cityRepo;

    public CityRepositoryAdapter(ICityRepositoryAdapter cityRepo) {
        this.cityRepo = cityRepo;
    }

    @Override
    public String saveCity(City city) {
        CityDBO cityDBO = cityRepo.save(new CityDBO(city));
        Optional<CityDBO> foundCity = cityRepo.findById(cityDBO.getId());
        if(foundCity.isPresent()) return "City Successfully Saved";
        else{
            return null;
        }
    }

    @Override
    public List<City> getCities() {
        List<CityDBO> cityDBOList = (List<CityDBO>) cityRepo.findAll();
        if(cityDBOList.isEmpty()) throw new EntityNotFoundException("Not Cities found");
        return cityDBOList.stream().map(CityDBO::toCity).collect(Collectors.toList());
    }
}
