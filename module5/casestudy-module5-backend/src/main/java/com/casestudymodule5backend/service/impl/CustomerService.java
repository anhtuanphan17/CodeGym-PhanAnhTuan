package com.casestudymodule5backend.service.impl;

import com.casestudymodule5backend.model.Customer;
import com.casestudymodule5backend.repository.ICustomerRepository;
import com.casestudymodule5backend.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

}
