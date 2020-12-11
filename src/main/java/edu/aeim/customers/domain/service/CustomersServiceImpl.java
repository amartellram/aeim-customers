package edu.aeim.customers.domain.service;

import edu.aeim.customers.domain.dto.Customer;
import edu.aeim.customers.repository.CustomersRepository;
import edu.aeim.customers.repository.mapper.CustomerMapper;
import edu.aeim.customers.repository.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServiceImpl implements CustomersService {
    @Autowired
    private CustomersRepository customersRepository;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = CustomerMapper.MAPPER.toEntity(customer);
        entity = this.customersRepository.save(entity);
        return CustomerMapper.MAPPER.toCustomer(entity);
    }

    @Override
    public List<Customer> findAll() {
        List<CustomerEntity> entities = this.customersRepository.findAll();
        return CustomerMapper.MAPPER.toCustomers(entities);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.customersRepository
                .findById(id)
                .map(CustomerMapper.MAPPER::toCustomer);
    }

    @Override
    public Customer update(Customer customer) {
        var customerEntity = CustomerMapper.MAPPER.toEntity(customer);
        return CustomerMapper.MAPPER.toCustomer(this.customersRepository.saveAndFlush(customerEntity));
    }

    @Override
    public void delete(Long id) {
        this.customersRepository.deleteById(id);
    }

}
