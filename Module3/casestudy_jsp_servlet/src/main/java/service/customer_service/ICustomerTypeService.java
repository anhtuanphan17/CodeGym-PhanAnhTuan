package service.customer_service;

import model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {

    CustomerType selectCustomerType(int id);

    List<CustomerType> selectAllCustomerType();
}
