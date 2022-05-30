package service;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {

    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> searchByCountry (String country) throws SQLException;

    public List<User> sortByName();

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    public void insertUpdateWithoutTransaction();


    public List<User> getUserList();

    public void edit_user(User user);

    void deleteUserById(int id);
}
