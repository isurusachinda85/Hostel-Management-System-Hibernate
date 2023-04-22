package lk.ijse.hostelManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String sid;
    private String name;
    private String address;
    private String contact;
    private LocalDate dob;
    private String gender;
    private LocalDate registerDate;
}
