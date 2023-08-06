package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.entity.Customer;
import com.example.ProgressTest.repository.CustomerRepository;
import com.example.ProgressTest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(String id, Customer customer) {
        Customer customerdb=customerRepository.findById(id).get();
        if(Objects.nonNull(customer.getName()) &&
                !"".equalsIgnoreCase(customer.getName())){
            customerdb.setName(customer.getName());
        }
        if(Objects.nonNull(customer.getAddress()) &&
                !"".equalsIgnoreCase(customer.getAddress())){
            customerdb.setAddress(customer.getAddress());
        }
        if(Objects.nonNull(customer.getSalary())){
            customerdb.setSalary(customer.getSalary());
        }
        return customerRepository.save(customerdb);
    }
}
