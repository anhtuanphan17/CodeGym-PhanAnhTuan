package repository.employee_repository;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> findAllEmployee();

    void insertEmployee(Employee employee);

    Employee findEmployeeById(Integer employeeId );

    void updateEmployee(Employee employee);

    void removeEmployeeById(Integer id);

    List<Employee> searchEmployeeByName(String searchWord);
}
