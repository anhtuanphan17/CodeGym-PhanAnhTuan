package repository.customer_repository.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.customer_repository.ICustomerRepository;
import repository.database_connect.BaseRepository;
import service.customer_service.impl.CustomerTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    CustomerTypeService customerTypeService = new CustomerTypeService();

    private static final String SELECT_ALL_CUSTOMERS = "SELECT * FROM customer";
    private static final String INSERT_CUSTOMER = "INSERT INTO customer(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) values(?,?,?,?,?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM customer WHERE customer_id = ?;";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?,customer_type_id=? WHERE customer_id=?;";
    private static final String DELETE_CUSTOMER_BY_ID = "DELETE FROM customer WHERE customer_id = ?;";
//    private static final String SEARCH_CUSTOMER_BY_NAME = "SELECT * FROM customer WHERE customer_name LIKE concat(\"%\",?,\"%\");";
    private static final String SEARCH_CUSTOMER_BY_NAME = "SELECT * FROM customer WHERE customer_name LIKE ?;";

    public BaseRepository getBaseRepository() {
        return baseRepository;
    }

    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                int gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                CustomerType customerTypeId = customerTypeService.selectCustomerType(resultSet.getInt("customer_type_id"));
                Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, customerTypeId);
                System.out.println(customer);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return customerList;
    }

    public void insertCustomer(Customer customer) {
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId().getCustomerTypeId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        Customer customer = null;
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, customerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                CustomerType customerTypeId = customerTypeService.selectCustomerType(resultSet.getInt("customer_type_id"));
                customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, customerTypeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setString(2, customer.getCustomerBirthday());
            preparedStatement.setInt(3, customer.getCustomerGender());
            preparedStatement.setString(4, customer.getCustomerIdCard());
            preparedStatement.setString(5, customer.getCustomerPhone());
            preparedStatement.setString(6, customer.getCustomerEmail());
            preparedStatement.setString(7, customer.getCustomerAddress());
            preparedStatement.setInt(8, customer.getCustomerTypeId().getCustomerTypeId());
            preparedStatement.setInt(9, customer.getCustomerId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteCustomerById(int id) {
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public List<Customer> searchCustomerByName(String searchWord) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);
            preparedStatement.setString(1,"%"+searchWord+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                String birthday = resultSet.getString("customer_birthday");
                Integer gender = resultSet.getInt("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                CustomerType customerType = customerTypeService.selectCustomerType(resultSet.getInt("customer_type_id"));
                Customer customer = new Customer(id, name, birthday, gender, idCard, phone, email, address, customerType);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerList;
    }

}
