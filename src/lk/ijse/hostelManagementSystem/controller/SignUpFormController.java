package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.UserBO;
import lk.ijse.hostelManagementSystem.bo.custom.impl.UserBOImpl;
import lk.ijse.hostelManagementSystem.dto.UserDTO;
import lk.ijse.hostelManagementSystem.entity.User;
import org.controlsfx.control.Notifications;


import java.io.IOException;

public class SignUpFormController {
    public AnchorPane signUpContext;
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtConfirmPassword;

    private final UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.USER);

    public void registerOnAction(ActionEvent actionEvent) {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String confirmPassword = txtConfirmPassword.getText();

        try {
            boolean saveUser = userBO.saveUser(new UserDTO(userName, password, confirmPassword));
            if (saveUser) {
                successNotification();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        clearText();
    }

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) signUpContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/hostelManagementSystem/view/LoginForm.fxml"))));
        stage.centerOnScreen();
    }

    public void clearText() {
        txtUserName.clear();
        txtPassword.clear();
        txtConfirmPassword.clear();
    }

    public void successNotification() {
        Notifications notificationBuilder = Notifications.create()
                .title("Success !")
                .text("User Register Successfully ")
                .graphic(new ImageView(new Image("/lk/ijse/hostelManagementSystem/view/assest/Done.png")))
                .hideAfter(Duration.seconds(8))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    public void failNotification() {
        Notifications notificationBuilder = Notifications.create()
                .title("UnSuccessful !")
                .text("User Not Register")
                .graphic(new ImageView(new Image("/lk/ijse/hostelManagementSystem/view/assest/Wrong.png")))
                .hideAfter(Duration.seconds(8))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }
}
