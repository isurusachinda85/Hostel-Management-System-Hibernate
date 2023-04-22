package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import lk.ijse.hostelManagementSystem.dao.custom.UserDAO;
import lk.ijse.hostelManagementSystem.dao.UserDAOImpl;
import lk.ijse.hostelManagementSystem.entity.User;

import java.io.IOException;

public class ManageUserController {

    @FXML
    private JFXTextField txtCurrentUserName;

    @FXML
    private JFXPasswordField txtCurrentPassword;

    @FXML
    private JFXPasswordField txtConfirmPassword;

    @FXML
    private JFXTextField txtNewUserName;

    @FXML
    private JFXPasswordField txtNewPassword;

    @FXML
    private JFXTextField txtUserId;

    private final UserDAO userDAO = new UserDAOImpl();

    @FXML
    void updateOnAction(ActionEvent event) {
        int id = Integer.parseInt(txtUserId.getText());
        String newUserName = txtNewUserName.getText();
        String newPassword = txtNewPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        User user = new User(id, newUserName, newPassword, confirmPassword);

        try {
            boolean updateUser = userDAO.update(user);
            if (updateUser) {
                new Alert(Alert.AlertType.INFORMATION, "Updated !").show();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void userOnAction(ActionEvent event) {
        String id = txtUserId.getText();

        try {
            User user = userDAO.search(id);
            if (user != null) {
                txtCurrentUserName.setText(user.getUserName());
                txtCurrentPassword.setText(user.getPassword());
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void cancelOnAction(ActionEvent event) {
        txtUserId.clear();
        txtCurrentUserName.clear();
        txtCurrentPassword.clear();
        txtNewUserName.clear();
        txtNewPassword.clear();
        txtConfirmPassword.clear();
    }

}
