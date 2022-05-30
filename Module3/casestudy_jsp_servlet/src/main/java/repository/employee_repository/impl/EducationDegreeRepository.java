package repository.employee_repository.impl;

import model.employee.EducationDegree;
import repository.database_connect.BaseRepository;
import repository.employee_repository.IEducationDegreeRepository;

import javax.lang.model.type.IntersectionType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EDUCATION_DEGREE_BY_ID = "SELECT * FROM `education_degree` WHERE education_degree_id =?";
    private static final String SELECT_ALL_EDUCATION_DEGREE = "SELECT * FROM education_degree; ";

    @Override
    public EducationDegree selectEducationDegreeById(int id) {
        EducationDegree educationDegree = null;
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                educationDegree = new EducationDegree(educationDegreeId,educationDegreeName);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return educationDegree;
    }

    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection;
        try {
            connection= baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EDUCATION_DEGREE);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Integer educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                EducationDegree educationDegree = new EducationDegree(educationDegreeId,educationDegreeName);
                educationDegreeList.add(educationDegree);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return educationDegreeList;
    }
}
