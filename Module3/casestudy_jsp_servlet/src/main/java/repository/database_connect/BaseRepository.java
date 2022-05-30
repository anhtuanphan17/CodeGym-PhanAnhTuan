package repository.database_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study_module_3_db_servlet?useSSL=false";
    private String jdbcUserName = "root";
    private String jdbcPassWord = "Anhtuan1712";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassWord);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
