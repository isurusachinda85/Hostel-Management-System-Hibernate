package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.dto.ReserveDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Reserve;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.List;

public interface ReservationBO extends SuperBO {
    boolean saveReservation(ReserveDTO dto) throws IOException;

    boolean updateReservation(ReserveDTO dto) throws IOException;

    boolean deleteReservation(String id) throws IOException;

    StudentDTO searchStudent(String id) throws IOException;

    RoomDTO searchRoom(String id) throws IOException;

    List<StudentDTO> getAllStudentId() throws IOException;

    List<RoomDTO> getAllRoomId() throws IOException;
}
