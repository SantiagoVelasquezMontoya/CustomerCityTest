package com.test.demo.infrastructure.entrypoint;


import com.test.demo.domain.model.customer.dto.CustomerDTO;
import com.test.demo.domain.usecase.CustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerEntryPoint {

    private CustomerUseCase customerUseCase;

    public CustomerEntryPoint(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }


    @GetMapping()
    public ResponseEntity<?> getCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerUseCase.getCustomers());
    }
    @PostMapping()
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerUseCase.saveCustomer(customerDTO));
    }

}
