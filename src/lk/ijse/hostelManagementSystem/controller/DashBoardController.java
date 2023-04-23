package lk.ijse.hostelManagementSystem.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.dto.UserDTO;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;


public class DashBoardController implements Initializable {

    public AnchorPane dashBoardContext;
    public AnchorPane mainContext;
    public Label lblUser;
    public Label lblDate;
    public Label lblTime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimeAndDate();
        setUserName();

    }
    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) dashBoardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void dashBoardOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) mainContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/DashBoard.fxml"))));
    }

    @FXML
    void addReservationOnAction(ActionEvent event) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/addReservationForm");
    }

    @FXML
    void manageRoomOnAction(ActionEvent event) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/RoomManageForm");
    }

    @FXML
    void manageStudentOnAction(ActionEvent event) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/StudentManageForm");
    }

    @FXML
    void viewReservationOnAction(ActionEvent event) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/viewReservationForm");
    }
    @FXML
    void settingOnAction(ActionEvent event) throws IOException {
        setUi("/lk/ijse/hostelManagementSystem/view/ManageUser");
    }
    private void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        mainContext.getChildren().clear();
        mainContext.getChildren().add(load);
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
    private void setUserName() {
        lblUser.setText(LoginFormController.getUserName());
        //System.out.println("inDashBoard"+LoginFormController.getUserName());
    }
}
