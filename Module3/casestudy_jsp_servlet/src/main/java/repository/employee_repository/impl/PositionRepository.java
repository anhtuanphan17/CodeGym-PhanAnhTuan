package repository.employee_repository.impl;

import model.employee.Position;
import repository.database_connect.BaseRepository;
import repository.employee_repository.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_POSITION_BY_ID = "SELECT * FROM `position` WHERE position_id =?";
    private static final String SELECT_ALL_POSITION = "SELECT * FROM position; ";

    @Override
    public Position selectPositionById(int id) {
        Connection connection;
        Position position = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                position = new Position(positionId, positionName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }


    public List<Position> selectAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection;

        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                Position position = new Position(positionId, positionName);
                positionList.add(position);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return positionList;
    }

}

