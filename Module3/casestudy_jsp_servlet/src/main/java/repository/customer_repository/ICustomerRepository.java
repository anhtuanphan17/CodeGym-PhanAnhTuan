package repository.customer_repository;

import model.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAllCustomers();

    void insertCustomer(Customer customer);

    Customer findCustomerById(Integer customerId);

    void updateCustomer(Customer customer);

    void deleteCustomerById(int id);

    List<Customer> searchCustomerByName(String searchWord);
}
