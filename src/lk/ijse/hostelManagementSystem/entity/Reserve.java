package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@NoArgsConstructor
@Data
@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Reserve{
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

    public Reserve(String reserveId, LocalDate date, String studentName, double monthlyRent, double paidKeyMoney, double dueKeyMoney, String paymentThisMonth, Room room, Student student) {
        this.reserveId = reserveId;
        this.date = date;
        this.studentName = studentName;
        this.monthlyRent = monthlyRent;
        this.paidKeyMoney = paidKeyMoney;
        this.dueKeyMoney = dueKeyMoney;
        this.paymentThisMonth = paymentThisMonth;
        this.room = room;
        this.student = student;
    }
}
