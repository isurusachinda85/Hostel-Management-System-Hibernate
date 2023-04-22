package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.RoomBO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.io.IOException;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    public boolean saveRoom(Room dto) throws IOException {
        return roomDAO.save(dto);
    }

    @Override
    public Room searchRoom(String id) throws IOException {
        return roomDAO.search(id);
    }

    @Override
    public boolean updateRoom(Room dto) throws IOException {
        return roomDAO.update(dto);
    }

    @Override
    public boolean deleteRoom(String id) throws IOException {
        return roomDAO.delete(id);
    }

    @Override
    public List<Room> getAllRoom() throws IOException {
        return roomDAO.getAll();
    }
}
