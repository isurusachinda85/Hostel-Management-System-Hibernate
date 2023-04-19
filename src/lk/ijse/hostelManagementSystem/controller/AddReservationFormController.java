package lk.ijse.hostelManagementSystem.controller;

import com.jfoenix.controls.JFXComboBox;
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
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.ResourceBundle;

public class AddReservationFormController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbStudentId;

    @FXML
    private JFXComboBox<String> cmbRoomId;

    @FXML
    private Label name;

    @FXML
    private Label address;

    @FXML
    private Label contact;

    @FXML
    private Label gender;

    @FXML
    private Label dob;

    @FXML
    private Label registerDate;

    @FXML
    private Label type;

    @FXML
    private Label roomQty;

    @FXML
    private Label availableQty;

    @FXML
    private Label roomAddDate;

    @FXML
    private JFXTextField txtMonthlyRent;

    @FXML
    private JFXTextField txtPaidKeyMoney;

    @FXML
    private JFXTextField txtDueRent;

    @FXML
    private JFXComboBox<String> cmbPaymentThisMonth;

    @FXML
    private TableView<?> tblReservation;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> coolStudentId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colMonthlyRent;

    @FXML
    private TableColumn<?, ?> colPaidKeyMoney;

    @FXML
    private TableColumn<?, ?> colDueRent;

    @FXML
    private TableColumn<?, ?> colPaymentThisMonth;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimeAndDate();
        setCmbPaymentThisMonth();
        loadStudentId();
        loadRoomId();
    }

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void reserveOnAction(ActionEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    public void loadStudentId() throws IOException {
        ObservableList<String> studentList = FXCollections.observableArrayList();

        String hql = "FROM Student";

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Student> list = query.list();
        for (Student student : list) {
            studentList.add(student.getSid());
            cmbStudentId.setItems(studentList);
        }
        transaction.commit();
        session.close();
    }

    @FXML
    void selectStudentOnAction(ActionEvent event) throws IOException {
        String id = cmbStudentId.getValue();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            name.setText(student.getName());
            address.setText(student.getAddress());
            contact.setText(student.getContact());
            gender.setText(student.getGender());
            dob.setText(String.valueOf(student.getDob()));
            registerDate.setText(String.valueOf(student.getRegisterDate()));
        }
        transaction.commit();
        session.close();
    }

    public void loadRoomId() throws IOException {
        ObservableList<String> roomList = FXCollections.observableArrayList();

        String hql = "FROM Room";

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        List<Room> list = query.list();
        for (Room room : list) {
            roomList.add(room.getRoomId());
            cmbRoomId.setItems(roomList);
        }
        transaction.commit();
        session.close();
    }

    @FXML
    void selectRoomOnAction(ActionEvent event) throws IOException {
        String id = cmbRoomId.getValue();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, id);
        if (room != null) {
            type.setText(room.getType());
            roomQty.setText(String.valueOf(room.getRoomsQty()));
            availableQty.setText(String.valueOf(room.getAvailableQty()));
            roomAddDate.setText(String.valueOf(room.getAddDate()));
            txtMonthlyRent.setText(String.valueOf(room.getMonthlyRent()));
        }
        transaction.commit();
        session.close();
    }

    @FXML
    void dueRentAction(KeyEvent event) {
        double monthlyRent = Double.parseDouble(txtMonthlyRent.getText());
        double paidKeyMony = Double.parseDouble(txtPaidKeyMoney.getText());
        double balance = monthlyRent - paidKeyMony;
        txtDueRent.setText(String.valueOf(balance));

        double a = Double.parseDouble(txtDueRent.getText());
        if (a<=0){
            cmbPaymentThisMonth.setValue("Paid");
        }else {
            cmbPaymentThisMonth.setValue("Not Paid");
        }
    }

    public void setCmbPaymentThisMonth() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Paid", "Not Paid");
        cmbPaymentThisMonth.setItems(list);
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
