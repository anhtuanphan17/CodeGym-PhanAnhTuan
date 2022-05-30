package repository.customer_repository;

import model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeRepository {

    CustomerType selectCustomerType(int id);

    List<CustomerType> selectAllCustomerType();



}
