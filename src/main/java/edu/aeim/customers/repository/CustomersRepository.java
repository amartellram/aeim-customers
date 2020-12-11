package edu.aeim.customers.repository;

import edu.aeim.customers.repository.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomerEntity, Long> {
}
