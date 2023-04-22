package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room>{

}
