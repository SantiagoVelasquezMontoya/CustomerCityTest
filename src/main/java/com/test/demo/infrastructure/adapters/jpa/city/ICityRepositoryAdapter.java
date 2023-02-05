package com.test.demo.infrastructure.adapters.jpa.city;

import com.test.demo.infrastructure.adapters.jpa.city.dbo.CityDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICityRepositoryAdapter extends JpaRepository<CityDBO, Integer> {
}
