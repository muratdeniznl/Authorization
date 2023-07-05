package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.Optional;

public interface CustomerService {
    public Iterable<Customer> findAll();
    public Optional<Customer> findByName(String name);
    public Customer createCustomer(Customer customer);
    public void deleteCustomer(long customerId);
}
