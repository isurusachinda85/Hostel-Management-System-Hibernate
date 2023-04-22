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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.ijse.hostelManagementSystem.dao.RoomDAO;
import lk.ijse.hostelManagementSystem.dao.RoomDAOImpl;
import lk.ijse.hostelManagementSystem.entity.Room;
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

public class RoomManageFormController implements Initializable {

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXComboBox<String> cmbRoomType;

    @FXML
    private JFXTextField txtMonthlyRent;

    @FXML
    private JFXTextField txtqty;

    @FXML
    private TableView<Room> tblRoom;

    @FXML
    private TableColumn<?, ?> colRoomId;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colMonthlyRent;

    @FXML
    private TableColumn<?, ?> colRoomQty;

    @FXML
    private TableColumn<?, ?> colAvailableQty;

    @FXML
    private TableColumn<?, ?> colAddDate;

    @FXML
    private JFXDatePicker txtAddDate;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadTimeAndDate();
        setCmbRoomType();
        getAllRoom();
        setCellValueFactory();
    }

    public void setCellValueFactory() {
        colRoomId.setCellValueFactory(new PropertyValueFactory<>("roomId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colMonthlyRent.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("roomsQty"));
        colAvailableQty.setCellValueFactory(new PropertyValueFactory<>("availableQty"));
        colAddDate.setCellValueFactory(new PropertyValueFactory<>("addDate"));
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        String id = txtId.getText();
        String type = cmbRoomType.getValue();
        double rent = Double.parseDouble(txtMonthlyRent.getText());
        int roomQty = Integer.parseInt(txtqty.getText());
        int availabelQty = Integer.parseInt(txtqty.getText());
        LocalDate addDate = txtAddDate.getValue();

        Room room = new Room(id, type, rent, roomQty, availabelQty, addDate);

        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            boolean saveRoom = roomDAO.saveRoom(room);
            if (saveRoom) {
                new Alert(Alert.AlertType.INFORMATION, "Save Room !").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Not Save Room !").show();
            }
            getAllRoom();
        } catch (IOException e) {
            System.out.println(e);
        }
        clearOnAction(event);
    }

    @FXML
    void searchOnAction(ActionEvent event) {
        String id = txtId.getText();

        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            Room room = roomDAO.searchRoom(id);
            if (room != null) {
                txtMonthlyRent.setText(String.valueOf(room.getMonthlyRent()));
                cmbRoomType.setValue(room.getType());
                txtqty.setText(String.valueOf(room.getRoomsQty()));
                txtAddDate.setValue(room.getAddDate());
            } else {
                new Alert(Alert.AlertType.WARNING, "Not Found Room !").show();
            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @FXML
    void updateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String type = cmbRoomType.getValue();
        double rent = Double.parseDouble(txtMonthlyRent.getText());
        int roomQty = Integer.parseInt(txtqty.getText());
        int availabelQty = Integer.parseInt(txtqty.getText());
        LocalDate addDate = txtAddDate.getValue();

        Room room = new Room(id, type, rent, roomQty, availabelQty, addDate);

        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            boolean updateRoom = roomDAO.updateRoom(room);
            if (updateRoom) {
                new Alert(Alert.AlertType.INFORMATION, "Updated !").show();
            }
            getAllRoom();
        } catch (IOException e) {
            System.out.println(e);
        }
        clearOnAction(event);
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            boolean deleteRoom = roomDAO.deleteRoom(id);
            if (deleteRoom) {
                new Alert(Alert.AlertType.INFORMATION, "Delete Room !").show();
            }
            getAllRoom();
        } catch (IOException e) {
            System.out.println(e);
        }

        clearOnAction(event);
    }

    public void getAllRoom() {
        ObservableList<Room> roomList = FXCollections.observableArrayList();

        roomList.clear();

        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            List<Room> list = roomDAO.getAllRoom();
            for (Room room : list) {
                roomList.add(room);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        tblRoom.setItems(roomList);
    }

    public void setCmbRoomType() {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Non-AC", "Non-AC/Food", "AC", "AC/Food");
        cmbRoomType.setItems(list);
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        txtId.clear();
        txtMonthlyRent.clear();
        cmbRoomType.getSelectionModel().clearSelection();
        txtqty.clear();
        txtAddDate.getEditor().clear();
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
