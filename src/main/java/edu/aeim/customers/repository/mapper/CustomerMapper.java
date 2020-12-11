package edu.aeim.customers.repository.mapper;

import edu.aeim.customers.domain.dto.Customer;
import edu.aeim.customers.repository.model.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAPPER = Mappers.getMapper(CustomerMapper.class);

    @Mapping(target = "customerId", source = "id")
    Customer toCustomer(CustomerEntity customerEntity);
    CustomerEntity toEntity(Customer customer) ;
    List<Customer> toCustomers(List<CustomerEntity> customerEntities);
}
