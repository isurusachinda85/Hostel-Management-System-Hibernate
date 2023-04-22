package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.entity.User;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public interface UserDAO extends CrudDAO<User> {

}
