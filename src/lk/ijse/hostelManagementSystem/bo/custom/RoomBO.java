package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.entity.Room;

import java.io.IOException;
import java.util.List;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto) throws IOException;

    RoomDTO searchRoom(String id) throws IOException;

    boolean updateRoom(RoomDTO dto) throws IOException;

    boolean deleteRoom(String id) throws IOException;

    List<RoomDTO> getAllRoom() throws IOException;
}
