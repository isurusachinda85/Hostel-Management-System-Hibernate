package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public interface RoomDAO {
    boolean saveRoom(Room room) throws IOException;

    Room searchRoom(String id) throws IOException;

    boolean updateRoom(Room room) throws IOException;

    boolean deleteRoom(String id) throws IOException;

    List<Room> getAllRoom() throws IOException;
}
