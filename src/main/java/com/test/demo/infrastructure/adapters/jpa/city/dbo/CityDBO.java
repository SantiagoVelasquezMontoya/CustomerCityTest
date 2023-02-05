package com.test.demo.infrastructure.adapters.jpa.city.dbo;


import com.test.demo.domain.model.city.City;
import com.test.demo.domain.model.city.CityId;
import com.test.demo.domain.model.city.CityName;
import com.test.demo.domain.model.city.CityTemperature;
import com.test.demo.domain.model.city.dto.CityDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name  = "city")
public class CityDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer temperature;


    public CityDBO(CityDTO city) {
        this.id = city.getId();
        this.name = city.getName();
        this.temperature = city.getTemperature();
    }

    public CityDBO(City city) {
        this.id = city.getId().getValue();
        this.name = city.getName().getValue();
        this.temperature = city.getTemperature().getValue();
    }

    public static City toCity(CityDBO city){
        return new City(
                new CityId(city.getId()),
                new CityName(city.getName()),
                new CityTemperature(city.getTemperature())
        );
    }
}
