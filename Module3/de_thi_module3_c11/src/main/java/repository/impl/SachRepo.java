package repository.impl;

import model.Sach;
import repository.ISachRepo;
import repository.database_connection.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepo implements ISachRepo {



    BaseRepository baseRepository = new BaseRepository();
//
    private static final String SELECT_SACH_BY_ID = "SELECT * FROM sach WHERE sach_id=?;";
    private static final String SELECT_ALL_SACH = "SELECT * FROM sach; ";
//


    @Override
    public List<Sach> findAllSach() {
        List<Sach> sachList = new ArrayList<>();
        Connection connection = null;

        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SACH);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer sachId = resultSet.getInt("sach_id");
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                Integer soLuong = resultSet.getInt("so_luong");
                Sach sach = new Sach(sachId,maSach,tenSach,tacGia,moTa,soLuong);
                sachList.add(sach);

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
        return sachList;
    }

    @Override
    public Sach findSachById(Integer sachId) {
        Connection connection =null;
        Sach sach = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SACH_BY_ID);
            preparedStatement.setInt(1, sachId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maSach = resultSet.getString("ma_sach");
                String tenSach = resultSet.getString("ten_sach");
                String tacGia = resultSet.getString("tac_gia");
                String moTa = resultSet.getString("mo_ta");
                Integer soLuong = resultSet.getInt("so_luong");
                 sach = new Sach(sachId,maSach,tenSach,tacGia,moTa,soLuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sach;


    }


//    @Override
//    public Position selectPositionById(int id) {
//        Connection connection;
//        Position position = null;
//        try {
//            connection = baseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION_BY_ID);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Integer positionId = resultSet.getInt("position_id");
//                String positionName = resultSet.getString("position_name");
//                position = new Position(positionId, positionName);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return position;
//    }
//
//
//    public List<Position> selectAllPosition() {
//        List<Position> positionList = new ArrayList<>();
//        Connection connection;
//
//        try {
//            connection = baseRepository.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_POSITION);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Integer positionId = resultSet.getInt("position_id");
//                String positionName = resultSet.getString("position_name");
//                Position position = new Position(positionId, positionName);
//                positionList.add(position);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return positionList;
//    }

}
