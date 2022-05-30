package service.customer_service;

import model.customer.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAllCustomers();

    void insertCustomer(Customer customer);


    Customer findCustomerById(Integer customerId);

    void updateCustomer(Customer customer);

    void removeCustomerById(int id);

    List<Customer> searchCustomerByName(String searchWord);
}
