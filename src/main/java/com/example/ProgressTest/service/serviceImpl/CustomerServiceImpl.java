package com.example.ProgressTest.service.serviceImpl;

import com.example.ProgressTest.entity.Customer;
import com.example.ProgressTest.repository.CustomerRepository;
import com.example.ProgressTest.service.CustomerService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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

    @Override
    public String exportReport()  {
        try {
            String path = "D:\\";
            List<Customer> customers = customerRepository.findAll();
            File file = ResourceUtils.getFile("classpath:CustomerReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customers);
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\customer.pdf");
            return "report generated in path : " + path;
        }catch (Exception e){
            return "report generated fail \n"+ e.getMessage();
        }



    }


    @Override
    public Page<Customer> findByPaginationAndSorting(int offset, int pageSize, String field) {
        Page<Customer> customers=customerRepository.findAll(PageRequest.of(offset,pageSize).withSort(Sort.by(Sort.Direction.ASC,field)));
        return customers;
    }
}
