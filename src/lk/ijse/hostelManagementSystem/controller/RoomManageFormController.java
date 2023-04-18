package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class RoomManageFormController implements Initializable {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXComboBox<?> cmbRoomType;

    @FXML
    private JFXTextField txtMonthlyRent;

    @FXML
    private JFXTextField txtqty;

    @FXML
    private TableView<?> tblRoom;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colMonthlyRent;

    @FXML
    private TableColumn<?, ?> colRoomQty;

    @FXML
    private TableColumn<?, ?> colAvailableQty;

    @FXML
    private TableColumn<?, ?> colAddDate;

    @FXML
    private JFXDatePicker txtAddDate;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimeAndDate();
    }


    @FXML
    void saveOnAction(ActionEvent event) {

    }

    @FXML
    void searchOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnAction(ActionEvent event) {
        txtId.clear();
        txtMonthlyRent.clear();
        cmbRoomType.getSelectionModel().clearSelection();
        txtqty.clear();
        txtAddDate.getEditor().clear();
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
