package service.employee_service.impl;

import model.employee.Employee;
import repository.employee_repository.IEmployeeRepository;
import repository.employee_repository.impl.EmployeeRepository;
import service.employee_service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAllEmployee();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(Integer employeeId) {
        return employeeRepository.findEmployeeById(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public void removeEmployeeById(Integer id) {
        employeeRepository.removeEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployeeByName(String searchWord) {
        return employeeRepository.searchEmployeeByName(searchWord);
    }
}
