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
import lk.ijse.hostelManagementSystem.entity.Room;
import lk.ijse.hostelManagementSystem.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
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
    private TableView<?> tblRoom;

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
    }


    @FXML
    void saveOnAction(ActionEvent event) throws IOException {
        String id = txtId.getText();
        String type = cmbRoomType.getValue();
        double rent = Double.parseDouble(txtMonthlyRent.getText());
        int roomQty = Integer.parseInt(txtqty.getText());
        int availabelQty = Integer.parseInt(txtqty.getText());
        LocalDate addDate = txtAddDate.getValue();

        Room room = new Room(id,type,rent,roomQty,availabelQty,addDate);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
    }

    @FXML
    void searchOnAction(ActionEvent event) throws IOException {
        String id = txtId.getText();
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, id);
        if (room != null) {
            txtMonthlyRent.setText(String.valueOf(room.getMonthlyRent()));
            cmbRoomType.setValue(room.getType());
            txtqty.setText(String.valueOf(room.getRoomsQty()));
            txtAddDate.setValue(room.getAddDate());
        }else {
            new Alert(Alert.AlertType.WARNING, "Not Found Room !").show();
        }
        transaction.commit();
        session.close();
    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    public void setCmbRoomType() {
        ObservableList<String>list = FXCollections.observableArrayList();
        list.addAll("Non-AC","Non-AC/Food","AC","AC/Food");
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
