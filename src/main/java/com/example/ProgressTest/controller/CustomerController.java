package com.example.ProgressTest.controller;

import com.example.ProgressTest.entity.Customer;
import com.example.ProgressTest.service.CustomerService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/main/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> allCustomers(){
        return customerService.findAll();
    }
    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }
    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable String id){
        return customerService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        customerService.deleteById(id);
    }
    @PutMapping("/{id}")
    public Customer update(@PathVariable("id") String id,
                       @RequestBody Customer customer){
        return customerService.update(id,customer);
    }

    @GetMapping("/filter/{offset}/{pageSize}/{field}")
    public Page<Customer> getUserWithPaginationAndSorting(
            @PathVariable int offset,
            @PathVariable int pageSize,
            @PathVariable String field
    ){
        return customerService.findByPaginationAndSorting(offset,pageSize,field);
    }
    @GetMapping("/report")
    public String getReport(){
        return customerService.exportReport();
    }

}
