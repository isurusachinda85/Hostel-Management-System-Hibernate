package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.entity.User;

import java.io.IOException;

public interface UserBO extends SuperBO {
    boolean saveUser(User dto) throws IOException;

    User searchUser(String id) throws IOException;

    boolean updateUser(User dto) throws IOException;
}
