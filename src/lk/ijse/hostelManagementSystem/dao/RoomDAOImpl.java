package lk.ijse.hostelManagementSystem.dao;

import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room room) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean update(Room room) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.load(Room.class, id);
        session.delete(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Room> getAll() throws IOException {
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
