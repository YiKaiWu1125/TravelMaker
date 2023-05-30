package ntou.cs.java2023.travelmaker;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookingController {
    @FXML
    private Button bookingBackButton;
    @FXML
    private Button bookingNextButton;
    @FXML
    private TableView<ViewPoint> bookingTable;
    @FXML
    private TableColumn<ViewPoint, String> attractionColumn;
    @FXML
    private TableColumn<ViewPoint, String> kkdayColumn;
    @FXML
    private TableColumn<ViewPoint, String> klookColumn;
    @FXML
    private TableColumn<ViewPoint, String> ezTravelColumn;
    @FXML
    private TableColumn<ViewPoint, Button> isbookingColumn;



    @FXML
    private void clickBookingBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) bookingBackButton.getScene().getWindow();
            currentStage.close();

            Stage searchStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("cart-view.fxml"));
            searchStage.setTitle("Travel Maker - 購物車");
            searchStage.setResizable(false);
            searchStage.setScene(new Scene(root));
            searchStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickBookingNextButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) bookingNextButton.getScene().getWindow();
            currentStage.close();

            Stage searchStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("export-view.fxml"));
            searchStage.setTitle("Travel Maker - 選擇檔案匯出格式");
            searchStage.setResizable(false);
            searchStage.setScene(new Scene(root));
            searchStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
