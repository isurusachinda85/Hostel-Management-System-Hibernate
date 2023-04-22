package lk.ijse.hostelManagementSystem.bo.custom.impl;

import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dao.DAOFactory;
import lk.ijse.hostelManagementSystem.dao.custom.ReservationDAO;
import lk.ijse.hostelManagementSystem.dao.custom.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.custom.StudentDAO;
import lk.ijse.hostelManagementSystem.dao.custom.impl.ReservationDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.dao.custom.impl.StudentDAOImpl;
import lk.ijse.hostelManagementSystem.dto.ReserveDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Reserve;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    private final ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.RESERVE);
    private final StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.STUDENT);
    private final RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOType.ROOM);

    @Override
    public boolean saveReservation(ReserveDTO dto) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, dto.getStudent());
        Room room = session.get(Room.class, dto.getRoom());
        Reserve reserve = new Reserve(dto.getReserveId(),dto.getDate(),dto.getStudentName(),dto.getMonthlyRent(),dto.getPaidKeyMoney(),dto.getDueKeyMoney(),dto.getPaymentThisMonth(),room,student);
        session.save(reserve);

        room.setAvailableQty(room.getRoomsQty()-1);
        session.update(room);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateReservation(ReserveDTO dto) throws IOException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, dto.getStudent());
        Room room = session.get(Room.class, dto.getRoom());
        Reserve reserve = new Reserve(dto.getReserveId(),dto.getDate(),dto.getStudentName(),dto.getMonthlyRent(),dto.getPaidKeyMoney(),dto.getDueKeyMoney(),dto.getPaymentThisMonth(),room,student);

        session.update(reserve);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteReservation(String id) throws IOException {
        return reservationDAO.delete(id);
    }

    @Override
    public StudentDTO searchStudent(String id) throws IOException {
        Student student = studentDAO.search(id);
        return new StudentDTO(
                student.getSid(),
                student.getName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender(),
                student.getRegisterDate());
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
    public List<StudentDTO> getAllStudentId() throws IOException {
        List<StudentDTO>studentList = new ArrayList<>();
        List<Student> all = studentDAO.getAll();
        for (Student student : all) {
            studentList.add(new StudentDTO(student.getSid(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender(),
                    student.getRegisterDate()));
        }

        return studentList;
    }

    @Override
    public List<RoomDTO> getAllRoomId() throws IOException {
        List<RoomDTO>roomList = new ArrayList<>();
        List<Room> all = roomDAO.getAll();
        for (Room room : all) {
            roomList.add(new RoomDTO(room.getRoomId(),
                    room.getType(),
                    room.getMonthlyRent(),
                    room.getRoomsQty(),
                    room.getAvailableQty(),
                    room.getAddDate()));
        }
        return roomList;
    }

    @Override
    public List<ReserveDTO> getAllReserve() throws IOException {
        List<ReserveDTO> reserveList = new ArrayList<>();
        List<Reserve> all = reservationDAO.getAll();
        for (Reserve reserve : all) {
            reserveList.add(new ReserveDTO(
                    reserve.getReserveId(),
                    reserve.getDate(),
                    reserve.getStudentName(),
                    reserve.getMonthlyRent(),
                    reserve.getPaidKeyMoney(),
                    reserve.getDueKeyMoney(),
                    reserve.getPaymentThisMonth(),
                    reserve.getRoom(),
                    reserve.getStudent()));
        }
        return reserveList;
    }
}
