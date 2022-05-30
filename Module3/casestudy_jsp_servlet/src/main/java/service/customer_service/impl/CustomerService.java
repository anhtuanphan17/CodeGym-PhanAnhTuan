package service.customer_service.impl;

import model.customer.Customer;
import repository.customer_repository.ICustomerRepository;
import repository.customer_repository.impl.CustomerRepository;
import service.customer_service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers() ;
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerRepository.findCustomerById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.updateCustomer(customer);
    }

    @Override
    public void removeCustomerById(int id) {
        customerRepository.deleteCustomerById(id);
    }

    @Override
    public List<Customer> searchCustomerByName(String searchWord) {
        return customerRepository.searchCustomerByName(searchWord);
    }


}
