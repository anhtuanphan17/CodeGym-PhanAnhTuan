package case_study.service;

import case_study.service.IService;

public interface ICustomerService extends IService {
    public void displayListCustomer();
    public void addNewCustomer();
    public void editCustomer();

}
