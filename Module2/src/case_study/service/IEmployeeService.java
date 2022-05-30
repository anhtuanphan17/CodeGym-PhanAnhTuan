package case_study.service;

import case_study.service.IService;

public interface IEmployeeService extends IService {
    public void displayListEmployees();
    public void addNewEmployee();
    public void editEmployee();

}
