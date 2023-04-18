package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class AddReservationFormController implements Initializable {

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
    private JFXComboBox<String> cmbPaymentThisMonth;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimeAndDate();
        setCmbPaymentThisMonth();
    }

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

    public void setCmbPaymentThisMonth(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Paid","Not Paid");
        cmbPaymentThisMonth.setItems(list);
    }
    public void loadTimeAndDate() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        LocalDate date = LocalDate.now();
        lblDate.setText(String.valueOf(date));
    }

}
