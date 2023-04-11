package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleNode;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController {

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
}
