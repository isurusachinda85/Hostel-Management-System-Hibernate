package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.dao.custom.UserDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.UserDAOImpl;
import lk.ijse.hostelManagementSystem.entity.User;

import java.io.IOException;

public class UserBOImpl {

    private final UserDAO userDAO = new UserDAOImpl();

    public boolean saveUser(User dto) throws IOException {
        return userDAO.save(dto);
    }
    public User searchUser(String id) throws IOException {
        return userDAO.search(id);
    }
    public boolean updateUser(User dto) throws IOException {
        return userDAO.update(dto);
    }
}
