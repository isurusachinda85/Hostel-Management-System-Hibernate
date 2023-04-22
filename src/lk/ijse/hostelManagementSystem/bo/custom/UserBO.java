package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.UserDTO;

import java.io.IOException;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO dto) throws IOException;

    UserDTO searchUser(String id) throws IOException;

    boolean updateUser(UserDTO dto) throws IOException;
}
