package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.io.IOException;
import java.util.List;

public class RoomBOImpl {

    private final RoomDAO roomDAO = new RoomDAOImpl();

    public boolean saveRoom(Room dto) throws IOException {
        return roomDAO.save(dto);
    }

    public Room searchRoom(String id) throws IOException {
        return roomDAO.search(id);
    }

    public boolean updateRoom(Room dto) throws IOException {
        return roomDAO.update(dto);
    }

    public boolean deleteRoom(String id) throws IOException {
        return roomDAO.delete(id);
    }

    public List<Room> getAllRoom() throws IOException {
         return roomDAO.getAll();
    }
}
