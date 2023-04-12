package lk.ijse.hostelManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class SignUpFormController {
    public AnchorPane signUpContext;

    public void signOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) signUpContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }
}
