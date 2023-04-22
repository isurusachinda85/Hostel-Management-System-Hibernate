package lk.ijse.hostelManagementSystem.dao;

import java.io.IOException;
import java.util.List;

public interface CrudDAO<T> {
    boolean save(T entity) throws IOException;

    T search(String id) throws IOException;

    boolean update(T entity) throws IOException;

    boolean delete(String id) throws IOException;

    List<T> getAll() throws IOException;
}
