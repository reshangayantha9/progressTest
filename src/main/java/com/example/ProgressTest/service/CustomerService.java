package com.example.ProgressTest.service;

import com.example.ProgressTest.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);

    List<Customer> findAll();

    Optional<Customer> findById(String id);

    void deleteById(String id);

    Customer update(String id, Customer customer);
}
