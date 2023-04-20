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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostelManagementSystem.entity.User;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


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

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        Session session = FactoryConfiguration.getInstance().getSession();
        String hql = "From User where userName =:user_name and password=:password";
        Query query = session.createQuery(hql);
        query.setParameter("user_name",userName);
        query.setParameter("password",password);
        User user = (User) query.uniqueResult();
        if (user != null) {
            Stage stage = (Stage) loginContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/DashBoard.fxml"))));
            stage.centerOnScreen();
        }else {
            System.out.println("error");
        }
        session.close();

    }

    public void signUpOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/SignUpForm.fxml"))));
        stage.centerOnScreen();
    }
}
