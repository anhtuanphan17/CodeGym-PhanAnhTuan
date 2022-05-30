package repo.impl;

import model.Color;
import repo.IColorRepo;
import repo.database_connection.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorRepo implements IColorRepo {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_COLOR_BY_ID = "SELECT * FROM `color` WHERE color_id =?";
    private static final String SELECT_ALL_COLOR = "SELECT * FROM `color`;";


    @Override
    public Color selectColorById(int id) {
        Color color = null;
        Connection connection =null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COLOR_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer colorId = resultSet.getInt("color_id");
                String colorName = resultSet.getString("color_name");
                color = new Color(colorId, colorName);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return color;
    }

    @Override
    public List<Color> selectAllColor() {

        List<Color> colorList = new ArrayList<>();
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COLOR);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer colorId = resultSet.getInt("color_id");
                String colorName = resultSet.getString("color_name");
                Color color = new Color(colorId, colorName);
                colorList.add(color);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return colorList;

    }
}
