package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reserve {
    @Id
    private String reserveId;
    private LocalDate date;
    private String studentName;
    private double monthlyRent;
    private double paidKeyMoney;
    private double dueKeyMoney;
    private String paymentThisMonth;
    @ManyToOne
    private Room room;
    @ManyToOne
    private Student student;

}
