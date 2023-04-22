package lk.ijse.hostelManagementSystem.bo.custom;

import lk.ijse.hostelManagementSystem.bo.SuperBO;
import lk.ijse.hostelManagementSystem.entity.Reserve;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.List;

public interface ReservationBO extends SuperBO {
    boolean saveReservation(Reserve dto) throws IOException;

    boolean updateReservation(Reserve dto);

    boolean deleteReservation(String id);

    Student searchStudent(String id) throws IOException;

    Room searchRoom(String id) throws IOException;

    List<Student> getAllStudentId() throws IOException;

    List<Room> getAllRoomId() throws IOException;
}
