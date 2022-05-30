package com.casestudymodule5backend.controller;

import com.casestudymodule5backend.model.Customer;
import com.casestudymodule5backend.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Iterable<Customer>> findAllCustomer(@PageableDefault(value = 2) Pageable pageable) {
        Page<Customer> customerList = this.customerService.findAllCustomer(pageable);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id){
        Customer customer = this.customerService.findCustomerById(id);
        if(customer == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        this.customerService.saveCustomer(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> editCustomer(@PathVariable Integer id,@RequestBody Customer customer) {
        if (this.customerService.findCustomerById(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.customerService.saveCustomer(customer);
        return new ResponseEntity <>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id){
        this.customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
