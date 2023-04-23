package lk.ijse.hostelManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.dto.ReserveDTO;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ViewReservationFormController implements Initializable {

    @FXML
    private TableView<ReserveDTO> tblReservation;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> coolStudentId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colMonthlyRent;

    @FXML
    private TableColumn<?, ?> colPaidKeyMoney;

    @FXML
    private TableColumn<?, ?> colDueRent;

    @FXML
    private TableColumn<?, ?> colPaymentThisMonth;

    @FXML
    private TableColumn<?, ?> colDate;

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.RESERVE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getAllReserve();
        setCellValueFactory();
    }
    public void setCellValueFactory() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room"));
        coolStudentId.setCellValueFactory(new PropertyValueFactory<>("student"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));
        colPaidKeyMoney.setCellValueFactory(new PropertyValueFactory<>("paidKeyMoney"));
        colDueRent.setCellValueFactory(new PropertyValueFactory<>("dueKeyMoney"));
        colPaymentThisMonth.setCellValueFactory(new PropertyValueFactory<>("paymentThisMonth"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    public void getAllReserve(){
        ObservableList<ReserveDTO> reserveList = FXCollections.observableArrayList();

        reserveList.clear();

        try {
            List<ReserveDTO> list = reservationBO.getAllReserve();
            for (ReserveDTO reserveDTO : list) {
                reserveList.add(reserveDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tblReservation.setItems(reserveList);
    }
}
