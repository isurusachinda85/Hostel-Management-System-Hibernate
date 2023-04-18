package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class StudentManageFormController implements Initializable {
    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXDatePicker txtDob;

    @FXML
    private JFXComboBox<String> cmbGender;

    @FXML
    private TableView<?> tblStudent;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colRegisterDate;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setCmbGender();
        loadTimeAndDate();
    }


    @FXML
    void saveOnAction(ActionEvent event) throws IOException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate dob = txtDob.getValue();
        String gender = cmbGender.getValue();
        LocalDate registerDate = LocalDate.parse(lblDate.getText());

        Student student = new Student(id, name, address, contact, dob, gender, registerDate);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        clearTextOnAction(event);
    }

    @FXML
    void searchOnAction(ActionEvent event) throws IOException {
        String id = txtId.getText();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            txtName.setText(student.getName());
            txtAddress.setText(student.getAddress());
            txtContact.setText(student.getContact());
            txtDob.setValue(student.getDob());
            cmbGender.setValue(student.getGender());
        } else {
            new Alert(Alert.AlertType.WARNING, "Not Found Student !").show();
        }
        transaction.commit();
        session.close();
    }

    @FXML
    void updateOnAction(ActionEvent event) throws IOException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        LocalDate dob = txtDob.getValue();
        String gender = cmbGender.getValue();
        LocalDate registerDate = LocalDate.parse(lblDate.getText());

        Student student = new Student(id, name, address, contact, dob, gender, registerDate);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }


    @FXML
    void deleteOnAction(ActionEvent event) throws IOException {
        String id = txtId.getText();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.load(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @FXML
    void clearTextOnAction(ActionEvent event) {
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        cmbGender.getSelectionModel().clearSelection();
        txtDob.getEditor().clear();
    }

    public void setCmbGender() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Male", "Female", "Other");
        cmbGender.setItems(list);
    }

    public void loadTimeAndDate() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        LocalDate date = LocalDate.now();
        lblDate.setText(String.valueOf(date));
    }

}
