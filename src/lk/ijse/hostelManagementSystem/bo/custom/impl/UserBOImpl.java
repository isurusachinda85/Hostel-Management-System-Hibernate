package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.UserBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.UserDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.UserDAOImpl;
import lk.ijse.hostelManagementSystem.dto.UserDTO;
import lk.ijse.hostelManagementSystem.entity.User;

import java.io.IOException;

public class UserBOImpl implements UserBO {

    private final UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.USER);

    @Override
    public boolean saveUser(UserDTO dto) throws IOException {
        return userDAO.save(new User(dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }

    @Override
    public UserDTO searchUser(String id) throws IOException {
        User user = userDAO.search(id);
        return new UserDTO(user.getUserName(),user.getPassword(),user.getConfirmPassword());
    }

    @Override
    public boolean updateUser(UserDTO dto) throws IOException {
        return userDAO.update(new User(dto.getUserName(), dto.getPassword(), dto.getConfirmPassword()));
    }
}
