package edu.aeim.customers.domain.service;

import edu.aeim.customers.domain.dto.Customer;
import edu.aeim.customers.repository.model.CustomerEntity;

import java.util.List;
import java.util.Optional;

public interface CustomersService {
    Customer save(Customer customer);
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer update(Customer customer);
    void delete(Long id);
}
