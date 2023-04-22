package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.entity.Room;

import java.io.IOException;
import java.util.List;

public interface RoomBo {
    boolean saveRoom(Room dto) throws IOException;

    Room searchRoom(String id) throws IOException;

    boolean updateRoom(Room dto) throws IOException;

    boolean deleteRoom(String id) throws IOException;

    List<Room> getAllRoom() throws IOException;
}
