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
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.bo.BOFactory;
import lk.ijse.hostelManagementSystem.bo.custom.ReservationBO;
import lk.ijse.hostelManagementSystem.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostelManagementSystem.dto.ReserveDTO;
import lk.ijse.hostelManagementSystem.dto.RoomDTO;
import lk.ijse.hostelManagementSystem.dto.StudentDTO;
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.entity.Student;
import org.controlsfx.control.Notifications;

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
    private TableView<ReserveDTO> tblReservation;

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

    private final ReservationBO reservationBO = (ReservationBO) BOFactory.getBoFactory().getBO(BOFactory.BOType.RESERVE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimeAndDate();
        setCmbPaymentThisMonth();
        loadStudentId();
        loadRoomId();
        getAllReserve();
        setCellValueFactory();
    }
    public void setCellValueFactory() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("room"));
        coolStudentId.setCellValueFactory(new PropertyValueFactory<>("student"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));
        colPaidKeyMoney.setCellValueFactory(new PropertyValueFactory<>("paidKeyMoney"));
        colDueRent.setCellValueFactory(new PropertyValueFactory<>("dueKeyMoney"));
        colPaymentThisMonth.setCellValueFactory(new PropertyValueFactory<>("paymentThisMonth"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
    }
    @FXML
    void reserveOnAction(ActionEvent event) {

        String roomId = cmbRoomId.getValue();
        String studentId = cmbStudentId.getValue();
        String reserveId = roomId + "-" + studentId;
        String studentName = name.getText();
        double monthlyRent = Double.parseDouble(txtMonthlyRent.getText());
        double paidKeyMoney = Double.parseDouble(txtPaidKeyMoney.getText());
        double dueRent = Double.parseDouble(txtDueRent.getText());
        String paymentThisMonth = cmbPaymentThisMonth.getValue();
        LocalDate reserveDate = LocalDate.parse(lblDate.getText());


        try {
            boolean saveReseve = reservationBO.saveReservation(new ReserveDTO(reserveId,reserveDate,
                    studentName,monthlyRent,paidKeyMoney,dueRent,paymentThisMonth,roomId,studentId));

            if (saveReseve) {
                successNotification();
            }else{
                failNotification();
            }
            getAllReserve();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void clearOnAction(ActionEvent event) {
        name.setText("");
        address.setText("");
        contact.setText("");
        gender.setText("");
        dob.setText("");
        registerDate.setText("");
        type.setText("");
        roomQty.setText("");
        availableQty.setText("");
        roomAddDate.setText("");
        txtMonthlyRent.clear();
        txtPaidKeyMoney.clear();
        txtDueRent.clear();
        cmbPaymentThisMonth.getSelectionModel().clearSelection();
        /*cmbStudentId.getSelectionModel().clearSelection();
        cmbRoomId.getSelectionModel().clearSelection();*/

    }

    public void getAllReserve(){
        ObservableList<ReserveDTO> reserveList = FXCollections.observableArrayList();

        reserveList.clear();

        try {
            List<ReserveDTO> list = reservationBO.getAllReserve();
            for (ReserveDTO reserveDTO : list) {
                reserveList.add(reserveDTO);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        tblReservation.setItems(reserveList);
    }
    public void loadStudentId() {
        ObservableList<String> studentList = FXCollections.observableArrayList();

        try {
            List<StudentDTO> list = reservationBO.getAllStudentId();
            for (StudentDTO student : list) {
                studentList.add(student.getSid());
                cmbStudentId.setItems(studentList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void selectStudentOnAction(ActionEvent event) {
        String id = cmbStudentId.getValue();

        try {
            StudentDTO student = reservationBO.searchStudent(id);
            if (student != null) {
                name.setText(student.getName());
                address.setText(student.getAddress());
                contact.setText(student.getContact());
                gender.setText(student.getGender());
                dob.setText(String.valueOf(student.getDob()));
                registerDate.setText(String.valueOf(student.getRegisterDate()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRoomId() {
        ObservableList<String> roomList = FXCollections.observableArrayList();

        try {
            List<RoomDTO> list = reservationBO.getAllRoomId();
            for (RoomDTO room : list) {
                roomList.add(room.getRoomId());
                cmbRoomId.setItems(roomList);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void selectRoomOnAction(ActionEvent event) {
        String id = cmbRoomId.getValue();

        try {
            RoomDTO room = reservationBO.searchRoom(id);
            if (room != null) {
                type.setText(room.getType());
                roomQty.setText(String.valueOf(room.getRoomsQty()));
                availableQty.setText(String.valueOf(room.getAvailableQty()));
                roomAddDate.setText(String.valueOf(room.getAddDate()));
                txtMonthlyRent.setText(String.valueOf(room.getMonthlyRent()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void dueRentAction(KeyEvent event) {
        double monthlyRent = Double.parseDouble(txtMonthlyRent.getText());
        double paidKeyMony = Double.parseDouble(txtPaidKeyMoney.getText());
        double balance = monthlyRent - paidKeyMony;
        txtDueRent.setText(String.valueOf(balance));

        double a = Double.parseDouble(txtDueRent.getText());
        if (a <= 0) {
            cmbPaymentThisMonth.setValue("Paid");
        } else {
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
    public void successNotification() {
        Notifications notificationBuilder = Notifications.create()
                .title("Success !")
                .text("Reservation Successfuly !")
                .graphic(new ImageView(new Image("/lk/ijse/hostelManagementSystem/view/assest/Done.png")))
                .hideAfter(Duration.seconds(8))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

    public void failNotification() {
        Notifications notificationBuilder = Notifications.create()
                .title("UnSuccessful !")
                .text("Reservation Un Successfuly !")
                .graphic(new ImageView(new Image("/lk/ijse/hostelManagementSystem/view/assest/Wrong.png")))
                .hideAfter(Duration.seconds(8))
                .position(Pos.BOTTOM_RIGHT);
        notificationBuilder.darkStyle();
        notificationBuilder.show();
    }

}
