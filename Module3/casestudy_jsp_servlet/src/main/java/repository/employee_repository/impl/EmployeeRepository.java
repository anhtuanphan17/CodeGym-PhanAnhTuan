package repository.employee_repository.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.database_connect.BaseRepository;
import repository.employee_repository.IEmployeeRepository;
import service.employee_service.IDivisionService;
import service.employee_service.IEducationDegreeService;
import service.employee_service.IPositionService;
import service.employee_service.impl.DivisionService;
import service.employee_service.impl.EducationDegreeService;
import service.employee_service.impl.PositionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    IPositionService positionService = new PositionService();
    IEducationDegreeService educationDegreeService = new EducationDegreeService();
    IDivisionService divisionService = new DivisionService();

    BaseRepository baseRepository = new BaseRepository();

    private static final String FIND_ALL_EMPLOYEE = "SELECT * FROM employee;";
    private static final String INSERT_EMPLOYEE = "INSERT INTO employee(employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) values(?,?,?,?,?,?,?,?,?,?);";
    private static final String FIND_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE employee_id =?;";
    private static final String UPDATE_EMPLOYEE_BY_ID = "UPDATE employee SET employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?,division_id=? WHERE employee_id=? ";
    private static final String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE employee_id =?;";
    private static final String SEARCH_EMPLOYEE_BY_NAME = "SELECT * FROM employee WHERE employee_name LIKE concat( \"%\",?,\"%\");";

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_EMPLOYEE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Position positionId = positionService.selectPositionById(resultSet.getInt("position_id"));
                EducationDegree educationDegreeId = educationDegreeService.selectEducationDegreeById(resultSet.getInt("education_degree_id"));
                Division divisionId = divisionService.selectDivisionById(resultSet.getInt("division_id"));
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void insertEmployee(Employee employee) {
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId().getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId().getDivisionId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = null;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Position positionId = positionService.selectPositionById(resultSet.getInt("position_id"));
                EducationDegree educationDegreeId = educationDegreeService.selectEducationDegreeById(resultSet.getInt("education_degree_id"));
                Division divisionId = divisionService.selectDivisionById(resultSet.getInt("division_id"));
                employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_BY_ID);
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId().getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId().getDivisionId());
            preparedStatement.setInt(11, employee.getEmployeeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEmployeeById(Integer id) {
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Employee> searchEmployeeByName(String searchWord) {
        List<Employee> employeeList = new ArrayList<>();
    Connection connection;

        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_BY_NAME);
            preparedStatement.setString(1,searchWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Position positionId = positionService.selectPositionById(resultSet.getInt("position_id"));
                EducationDegree educationDegreeId = educationDegreeService.selectEducationDegreeById(resultSet.getInt("education_degree_id"));
                Division divisionId = divisionService.selectDivisionById(resultSet.getInt("division_id"));
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, educationDegreeId, divisionId);
                employeeList.add(employee);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
