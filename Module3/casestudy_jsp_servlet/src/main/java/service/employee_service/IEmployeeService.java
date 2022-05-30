package service.employee_service;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAllEmployee();

    void insertEmployee(Employee employee);

    Employee findEmployeeById(Integer employeeId);

    void updateEmployee(Employee employee);

    void removeEmployeeById(Integer id);

    List<Employee> searchEmployeeByName(String searchWord);
}
