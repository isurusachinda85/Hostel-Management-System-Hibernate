package lk.ijse.hostelManagementSystem.dto;

import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;

import java.time.LocalDate;

public class ReserveDTO {
    private String reserveId;
    private LocalDate date;
    private String studentName;
    private double monthlyRent;
    private double paidKeyMoney;
    private double dueKeyMoney;
    private String paymentThisMonth;
    private Room room;
    private Student student;
}
