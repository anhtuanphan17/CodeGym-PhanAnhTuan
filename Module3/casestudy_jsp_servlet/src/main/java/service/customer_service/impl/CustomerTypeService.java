package service.customer_service.impl;

import model.customer.CustomerType;
import repository.customer_repository.ICustomerTypeRepository;
import repository.customer_repository.impl.CustomerTypeRepository;
import service.customer_service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepository customerTypeRepository =new CustomerTypeRepository();


    @Override
    public CustomerType selectCustomerType(int id) {
        return customerTypeRepository.selectCustomerType(id)  ;
    }

    @Override
    public List<CustomerType> selectAllCustomerType() {
        return customerTypeRepository.selectAllCustomerType();
    }
}
