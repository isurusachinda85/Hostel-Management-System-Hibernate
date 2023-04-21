package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.entity.User;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.controlsfx.control.Notifications;
import org.hibernate.Session;
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
        query.setParameter("user_name", userName);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        if (user != null) {
            Stage stage = (Stage) loginContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/DashBoard.fxml"))));
            stage.centerOnScreen();
            successNotification();
        } else {
            failNotification();
        }
        session.close();

    }

    public void signUpOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/SignUpForm.fxml"))));
        stage.centerOnScreen();
    }

    @FXML
    void userNameOnAction(ActionEvent event) {
        txtPassword.requestFocus();
    }

    @FXML
    void paswordOnAction(ActionEvent event) throws IOException {
        loginOnAction(event);
    }

    public void successNotification() {
        Notifications notificationBuilder = Notifications.create()
                .title("Success !")
                .text("You have Successfully Login")
                .graphic(new ImageView(new Image("/lk/ijse/hostelManagementSystem/view/assest/Done.png")))
                .hideAfter(Duration.seconds(8))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    public void failNotification() {
        Notifications notificationBuilder = Notifications.create()
                .title("UnSuccessful !")
                .text("Please enter Correct User Name or Password.Try Again.!")
                .graphic(new ImageView(new Image("/lk/ijse/hostelManagementSystem/view/assest/Wrong.png")))
                .hideAfter(Duration.seconds(8))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

}
