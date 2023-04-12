package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleNode;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;


public class LoginFormController {

    public AnchorPane loginContext;
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXToggleNode btnTogle;

    @FXML
    void passwordType(KeyEvent event) {

    }

    @FXML
    void togleOnAction(ActionEvent event) {

    }

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/SignUpForm.fxml"))));
        stage.centerOnScreen();
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/DashBoard.fxml"))));
        stage.centerOnScreen();
    }
}
