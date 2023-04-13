package lk.ijse.hostelManagementSystem.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class DashBoardController {

    public AnchorPane dashBoardContext;
    public AnchorPane mainContext;

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

    private void setUi(String ui) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        mainContext.getChildren().clear();
        mainContext.getChildren().add(load);
    }
}
