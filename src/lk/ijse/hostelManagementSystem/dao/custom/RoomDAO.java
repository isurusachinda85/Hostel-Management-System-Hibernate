package lk.ijse.hostelManagementSystem.dao.custom;

import lk.ijse.hostelManagementSystem.dao.CrudDAO;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room> {

}
