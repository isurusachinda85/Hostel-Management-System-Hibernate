package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddReservationFormController {

    @FXML
    private JFXComboBox<?> cmbStudentId;

    @FXML
    private JFXComboBox<?> cmbRoomId;

    @FXML
    private Label name;

    @FXML
    private Label address;

    @FXML
    private Label contact;

    @FXML
    private Label gender;

    @FXML
    private Label dob;

    @FXML
    private Label registerDate;

    @FXML
    private Label type;

    @FXML
    private Label roomQty;

    @FXML
    private Label availableQty;

    @FXML
    private Label roomAddDate;

    @FXML
    private JFXTextField txtMonthlyRent;

    @FXML
    private JFXTextField txtPaidKeyMoney;

    @FXML
    private JFXTextField txtDueRent;

    @FXML
    private JFXComboBox<?> cmbPaymentThisMonth;

    @FXML
    private TableView<?> tblReservation;

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

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void reserveOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

}
