package edu.aeim.customers.web;

import edu.aeim.customers.domain.dto.Customer;
import edu.aeim.customers.domain.service.CustomersService;
import edu.aeim.customers.repository.model.CustomerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping
    public List<Customer> findAll() {
        return this.customersService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return this.customersService.save(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable(name = "id") Long id) {
        var optionalCustomer = this.customersService.findById(id);
        return optionalCustomer.map(
                customer -> new ResponseEntity<>(customer, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable(name = "id") String id, @RequestBody Customer customer) {
        customer.setCustomerId(id);
        return this.customersService.update(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        this.customersService.delete(id);
    }

}

