package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.entity.User;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public interface UserDAO {
    boolean saveUser(User user) throws IOException;

    User searchUser(int id) throws IOException;

    boolean updateUser(User user) throws IOException;
}
