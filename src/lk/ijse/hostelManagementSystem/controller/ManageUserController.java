package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.hostelManagementSystem.entity.User;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    @FXML
    void updateOnAction(ActionEvent event) throws IOException {
        int id = Integer.parseInt(txtUserId.getText());
        String newUserName = txtNewUserName.getText();
        String newPassword = txtNewPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        User user = new User(id, newUserName, newPassword, confirmPassword);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    @FXML
    void userOnAction(ActionEvent event) throws IOException {
        int id = Integer.parseInt(txtUserId.getText());

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null) {
            txtCurrentUserName.setText(user.getUserName());
            txtCurrentPassword.setText(user.getPassword());
        }
        transaction.commit();
        session.close();
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
