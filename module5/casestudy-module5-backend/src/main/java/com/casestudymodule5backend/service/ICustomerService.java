package com.casestudymodule5backend.service;

import com.casestudymodule5backend.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAllCustomer(Pageable pageable);

    void saveCustomer(Customer customer);

    Customer findCustomerById(Integer id);

    void deleteCustomer(Integer id);
}
