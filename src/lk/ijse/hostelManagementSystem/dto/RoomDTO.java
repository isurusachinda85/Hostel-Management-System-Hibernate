package lk.ijse.hostelManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoomDTO {
    private String roomId;
    private String type;
    private double monthlyRent;
    private int roomsQty;
    private int availableQty;
    private LocalDate addDate;
}
