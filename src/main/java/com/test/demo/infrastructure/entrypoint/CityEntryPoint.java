package com.test.demo.infrastructure.entrypoint;

import com.test.demo.domain.model.city.dto.CityDTO;
import com.test.demo.domain.usecase.CityUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
public class CityEntryPoint {


    private final CityUseCase cityUseCase;

    public CityEntryPoint(CityUseCase cityUseCase) {
        this.cityUseCase = cityUseCase;
    }

    @GetMapping()
    public ResponseEntity<?> getCities(){
        return ResponseEntity.status(HttpStatus.OK).body(cityUseCase.getCities());
    }
    @PostMapping()
    public ResponseEntity<?> saveCity(@RequestBody CityDTO cityDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityUseCase.saveCity(cityDTO));
    }
}
