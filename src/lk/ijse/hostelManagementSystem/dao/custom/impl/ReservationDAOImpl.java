package lk.ijse.hostelManagementSystem.dao.custom.impl;

import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.entity.Reserve;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reserve reserve) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(reserve);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Reserve search(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Reserve reserve = session.get(Reserve.class, id);
        transaction.commit();
        session.close();
        return reserve;
    }

    @Override
    public boolean update(Reserve reserve) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(reserve);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Reserve reserve = session.load(Reserve.class, id);
        session.delete(reserve);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Reserve> getAll() throws IOException {
        String hql = "FROM Reserve";

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Reserve> list = query.list();
        transaction.commit();
        session.close();
        return list;
    }
}
