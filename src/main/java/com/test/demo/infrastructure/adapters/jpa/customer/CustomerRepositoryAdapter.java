package com.test.demo.infrastructure.adapters.jpa.customer;

import com.test.demo.domain.model.customer.Customer;
import com.test.demo.domain.model.customer.gateway.CustomerRepository;
import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryAdapter implements CustomerRepository {

    private ICustomerRepositoryAdapter  customerRepo;

    public CustomerRepositoryAdapter(ICustomerRepositoryAdapter customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public String saveCustomer(Customer customer) {
        CustomerDBO customerDBO = customerRepo.save(new CustomerDBO(customer));
        Optional<CustomerDBO> foundCustomer = customerRepo.findById(customerDBO.getId());
        if(foundCustomer.isPresent()) return "Customer Successfully Saved";
        else{
            return null;
        }
    }


    @Override
    public List<Customer> getCustomers() {
        List<CustomerDBO> customerDBOList = (List<CustomerDBO>) customerRepo.findAll();
        if(customerDBOList.isEmpty()) throw new EntityNotFoundException("Not customers found");
        return customerDBOList.stream().map(CustomerDBO::toCustomer).collect(Collectors.toList());
    }
}
