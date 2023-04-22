package lk.ijse.hostelManagementSystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomEntity {
    private int id;
    private String userName;
    private String password;
    private String confirmPassword;

    private String sid;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;
    private LocalDate registerDate;

    private String roomId;
    private String type;
    private double monthlyRent;
    private int roomsQty;
    private int availableQty;
    private LocalDate addDate;

    private String reserveId;
    private LocalDate date;
    private String studentName;
    private double paidKeyMoney;
    private double dueKeyMoney;
    private String paymentThisMonth;


}
