package repository.employee_repository.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import repository.database_connect.BaseRepository;
import repository.employee_repository.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {

    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_DIVISION_BY_ID = "SELECT * FROM `division` WHERE division_id =?";
    private static final String SELECT_ALL_DIVISION = "SELECT * FROM division; ";


    @Override
    public Division selectDivisionById(int id) {
        Division division = null;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                division = new Division(divisionId, divisionName);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return division;

    }

    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                Division division = new Division(divisionId, divisionName);
                divisionList.add(division);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return divisionList;

    }
}
