package repository.impl;

import com.sun.corba.se.pept.transport.ConnectionCache;
import model.User;
import repository.data_connect.BaseRepository;
import repository.IUserRepository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class UserRepository implements IUserRepository {

    private static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country) VALUES(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_BY_COUNTRY = "select * from users where country = ?;";
    private static final String SORT_BY_NAME = "select * from users order by name;";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";


    BaseRepository baseRepository = new BaseRepository();


    @Override
    public void insertUser(User user) throws SQLException {
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public User selectUser(int id) {
        User user = null;
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");

                users.add(new User(id, name, email, country));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;

        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
        preparedStatement.setInt(1, id);
        rowDelete = preparedStatement.executeUpdate() > 0;

        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        Connection connection = baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getCountry());
        preparedStatement.setInt(4, user.getId());

        rowUpdate = preparedStatement.executeUpdate() > 0;

        connection.close();


        return rowUpdate;
    }

    @Override
    public List<User> searchByCountry(String search) {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_COUNTRY);
            preparedStatement.setString(1, search);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
                System.out.println(userList);
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
        return userList;
    }

    public List<User> sortByName() {
        List<User> userList = new ArrayList<>();
        Connection connection = null;
        try {
            connection = baseRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SORT_BY_NAME);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
                System.out.println(userList);
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
        return userList;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(id, name, email, country);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?,?)}";
        Connection connection;
        try {
            connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmtAssignment = null;
        ResultSet resultSet = null;

        try {
            connection = baseRepository.getConnection();
            connection.setAutoCommit(false);
            pstmt = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getCountry());
            int rowAffected = pstmt.executeUpdate();

            resultSet = pstmt.getGeneratedKeys();
            int userId = 0;

            if (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permission(user_id,permission_id) values(?,?);";
                pstmtAssignment = connection.prepareStatement(sqlPivot);
                for (int permissionId : permisions) {
                    pstmtAssignment.setInt(1, userId);
                    pstmtAssignment.setInt(2, permissionId);
                }
                connection.commit();
            } else {
                connection.rollback();
            }


        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.getMessage();
                }
            }
            System.out.println(e.getMessage());

        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (pstmtAssignment != null) {
                    pstmtAssignment.close();
                }
                if (connection != null) {
                    connection.commit();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    @Override
    public void insertUpdateWithoutTransaction() {
        Connection connection;
        try {
            connection = baseRepository.getConnection();

            Statement statement = connection.createStatement();

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);


            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);


            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();
            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();
            // Run list of update commands
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        String query = "{CALL get_user_list()}";

        Connection connection;
        try {
            connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void edit_user(User user) {
        String query = "{call edit_user_by_id(?,?,?,?)}";
        Connection connection;
        try{
            connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,user.getId());
            callableStatement.setString(2,user.getName());
            callableStatement.setString(3,user.getEmail());
            callableStatement.setString(4,user.getCountry());
            callableStatement.executeUpdate();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteUserById(int id){
        Connection connection ;
        String query = "{call delete_user(?)}";
        try {
            connection = baseRepository.getConnection();
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setInt(1,id);
            callableStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }


    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

