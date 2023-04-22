package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.UserBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.UserDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.UserDAOImpl;
import lk.ijse.hostelManagementSystem.entity.User;

import java.io.IOException;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.USER);

    @Override
    public boolean saveUser(User dto) throws IOException {
        return userDAO.save(dto);
    }

    @Override
    public User searchUser(String id) throws IOException {
        return userDAO.search(id);
    }

    @Override
    public boolean updateUser(User dto) throws IOException {
        return userDAO.update(dto);
    }
}
