package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.entity.User;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public interface UserDAO extends CrudDAO<User>{

}
