package repo.impl;

import model.Category;
import model.Color;
import repo.ICategoryRepo;
import repo.database_connection.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepo implements ICategoryRepo {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM `category` WHERE category_id =?";
    private static final String SELECT_ALL_CATEGORY = "SELECT * FROM `category`;";

    @Override
    public Category selectCategoryById(int id) {
        Category category = null;
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer categoryId = resultSet.getInt("category_id");
                String categoryName = resultSet.getString("category_name");
                category = new Category(categoryId, categoryName);

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

        return category;

    }

    @Override
    public List<Category> selectAllCategory() {

        List<Category> categoryList = new ArrayList<>();
        Connection connection=null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer category_id = resultSet.getInt("category_id");
                String category_name = resultSet.getString("category_name");
                Category category = new Category(category_id, category_name);
                categoryList.add(category);
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
        return categoryList;
    }
}
