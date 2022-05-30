package service.impl;

import model.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    IUserRepository iUserRepository = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return iUserRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return iUserRepository.updateUser(user);
    }

    @Override
    public List<User> searchByCountry(String country) throws SQLException {
        return iUserRepository.searchByCountry(country);
    }

    @Override
    public List<User> sortByName() {
        return iUserRepository.sortByName();
    }

    @Override
    public User getUserById(int id) {
        return iUserRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        iUserRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {
        iUserRepository.addUserTransaction(user, permisions);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        iUserRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public List<User> getUserList() {
        return iUserRepository.getUserList();
    }

    @Override
    public void edit_user(User user) {
    iUserRepository.edit_user(user);
    }

    @Override
    public void deleteUserById(int id) {
        iUserRepository.deleteUserById(id);
    }

}
