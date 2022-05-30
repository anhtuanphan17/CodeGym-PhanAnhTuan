package repository.customer_repository.impl;

import model.customer.CustomerType;
import repository.customer_repository.ICustomerTypeRepository;
import repository.database_connect.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_CUSTOMER_TYPE_BY_ID = "SELECT * FROM customer_type WHERE customer_type_id = ?;";
    private static final String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM customer_type;";
    BaseRepository baseRepository = new BaseRepository();


    @Override
    public CustomerType selectCustomerType(int id) {
        CustomerType customerType = null;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_TYPE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String customerTypeName = resultSet.getString("customer_type_name");
                customerType = new CustomerType(id, customerTypeName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerType;
    }


    public List<CustomerType> selectAllCustomerType()  {
        Connection connection;
        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(id, customerTypeName);
                customerTypeList.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }

}
