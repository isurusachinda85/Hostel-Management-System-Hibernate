package lk.ijse.hostelManagementSystem.dto;

import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
