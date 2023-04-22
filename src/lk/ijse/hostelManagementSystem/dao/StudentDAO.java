package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public interface StudentDAO extends CrudDAO<Student>{

}
