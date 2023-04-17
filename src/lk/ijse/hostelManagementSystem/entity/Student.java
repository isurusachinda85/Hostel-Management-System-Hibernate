package lk.ijse.hostelManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    private String sid;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;
    private LocalDate registerDate;
    @OneToMany
    private List<Reserve>reserveList = new ArrayList<>();
}
