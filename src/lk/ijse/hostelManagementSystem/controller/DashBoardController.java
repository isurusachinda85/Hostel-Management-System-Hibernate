package lk.ijse.hostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    void addReservationOnAction(ActionEvent event) {

    }

    @FXML
    void dashBoardOnAction(ActionEvent event) {

    }

    @FXML
    void manageRoomOnAction(ActionEvent event) {

    }

    @FXML
    void manageStudentOnAction(ActionEvent event) {

    }

    @FXML
    void viewReservationOnAction(ActionEvent event) {

    }
}
