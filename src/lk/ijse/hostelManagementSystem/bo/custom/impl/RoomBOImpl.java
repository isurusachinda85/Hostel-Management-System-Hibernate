package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.RoomBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.ROOM);

    @Override
    public boolean saveRoom(RoomDTO dto) throws IOException {
        return roomDAO.save(new Room(
                dto.getRoomId(),dto.getType(), dto.getMonthlyRent(),dto.getRoomsQty(), dto.getAvailableQty(),dto.getAddDate()));
    }

    @Override
    public RoomDTO searchRoom(String id) throws IOException {
        Room room = roomDAO.search(id);
        return new RoomDTO(
                room.getRoomId(),
                room.getType(),
                room.getMonthlyRent(),
                room.getRoomsQty(),
                room.getAvailableQty(),
                room.getAddDate());
    }

    @Override
    public boolean updateRoom(RoomDTO dto) throws IOException {
        return roomDAO.update(new Room(
                dto.getRoomId(),dto.getType(), dto.getMonthlyRent(),dto.getRoomsQty(), dto.getAvailableQty(),dto.getAddDate()));
    }

    @Override
    public boolean deleteRoom(String id) throws IOException {
        return roomDAO.delete(id);
    }

    @Override
    public List<RoomDTO> getAllRoom() throws IOException {
        List<RoomDTO>allRoom = new ArrayList<>();
        List<Room> all = roomDAO.getAll();
        for (Room room : all) {
            allRoom.add(new RoomDTO(room.getRoomId(),
                    room.getType(),
                    room.getMonthlyRent(),
                    room.getRoomsQty(),
                    room.getAvailableQty(),
                    room.getAddDate()));
        }
        return allRoom;
    }
}
