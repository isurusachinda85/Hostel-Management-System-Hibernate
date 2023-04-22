package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Reserve;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.io.IOException;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    private final ReservationDAO reservationDAO = new ReservationDAOImpl();
    private final StudentDAO studentDAO = new StudentDAOImpl();
    private final RoomDAO roomDAO = new RoomDAOImpl();

    @Override
    public boolean saveReservation(Reserve dto) throws IOException {
        return true;
    }

    @Override
    public boolean updateReservation(Reserve dto) {
        return false;
    }

    @Override
    public boolean deleteReservation(String id) {
        return true;
    }

    @Override
    public Student searchStudent(String id) throws IOException {
        return studentDAO.search(id);
    }

    @Override
    public Room searchRoom(String id) throws IOException {
        return roomDAO.search(id);
    }

    @Override
    public List<Student> getAllStudentId() throws IOException {
        /*List<Student>studentList = new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            
        }*/
        return studentDAO.getAll();
    }

    @Override
    public List<Room> getAllRoomId() throws IOException {
        /*List<Room>roomList = new ArrayList<>();
        List<Room> all = roomDAO.getAll();
        for (Room room : all) {
            
        }*/
        return roomDAO.getAll();
    }
}
