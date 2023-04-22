package lk.ijse.hostelManagementSystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean saveRoom(Room room) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room searchRoom(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean updateRoom(Room room) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteRoom(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.load(Room.class, id);
        session.delete(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Room> getAllRoom() throws IOException {
        String hql = "FROM Room";

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Room> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}
