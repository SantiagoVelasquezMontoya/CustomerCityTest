package com.test.demo.application;


import com.test.demo.domain.model.city.gateway.CityRepository;
import com.test.demo.domain.model.customer.gateway.CustomerRepository;
import com.test.demo.domain.usecase.CityUseCase;
import com.test.demo.domain.usecase.CustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {



    @Bean
    public CustomerUseCase customerUseCase(CustomerRepository customerRepository){
        return new CustomerUseCase(customerRepository);
    }

    @Bean
    public CityUseCase cityUseCase(CityRepository cityRepository){
        return new CityUseCase(cityRepository);
    }
}
