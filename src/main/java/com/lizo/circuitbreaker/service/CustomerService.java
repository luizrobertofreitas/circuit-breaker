package com.lizo.circuitbreaker.service;

import com.lizo.circuitbreaker.model.entity.Customer;
import com.lizo.circuitbreaker.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> all() {
        return customerRepository.findAll();
    }

    public void init() {
        List<Customer> customers = new ArrayList<>();
        customers.add(Customer.builder().id(1).name("Fernanda").build());
        customers.add(Customer.builder().id(2).name("Carol").build());
        customers.add(Customer.builder().id(3).name("Marina").build());
        customers.add(Customer.builder().id(4).name("Rita").build());
        customers.add(Customer.builder().id(5).name("Camila").build());
        customers.add(Customer.builder().id(6).name("Ester").build());
        customers.add(Customer.builder().id(7).name("Ivone").build());
        customerRepository.saveAll(customers);
    }

}