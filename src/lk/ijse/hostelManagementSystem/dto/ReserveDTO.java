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
    private String room;
    private String student;

    public ReserveDTO(String reserveId, LocalDate date, String studentName, double monthlyRent, double paidKeyMoney, double dueKeyMoney, String paymentThisMonth, Room room, Student student) {
    }

}
