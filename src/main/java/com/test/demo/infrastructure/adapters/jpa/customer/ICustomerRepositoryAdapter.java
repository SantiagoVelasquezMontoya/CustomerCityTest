package com.test.demo.infrastructure.adapters.jpa.customer;

import com.test.demo.infrastructure.adapters.jpa.customer.dbo.CustomerDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepositoryAdapter extends JpaRepository<CustomerDBO, Integer> {
}
