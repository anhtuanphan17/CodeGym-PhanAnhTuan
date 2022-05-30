package com.casestudymodule5backend.repository;

import com.casestudymodule5backend.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
