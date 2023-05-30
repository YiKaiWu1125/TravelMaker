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
    private TravelItinerary cartTravelItinerary;

    public void setCartTravelItinerary(TravelItinerary cartTravelItinerary){
        this.cartTravelItinerary = cartTravelItinerary;
    }

    @FXML
    private void clickBookingBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) bookingBackButton.getScene().getWindow();
            currentStage.close();

            Stage cartStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart-view.fxml"));
            Parent root = loader.load();
            CartController cartController = loader.getController();
            cartController.setCartTravelItinerary(cartTravelItinerary);

            cartStage.setTitle("Travel Maker - 購物車");
            cartStage.setResizable(false);
            cartStage.setScene(new Scene(root));
            cartStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickBookingNextButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) bookingNextButton.getScene().getWindow();
            currentStage.close();

            Stage exportStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("export-view.fxml"));
            Parent root = loader.load();
            ExportController exportController = loader.getController();
            exportController.setCartTravelItinerary(cartTravelItinerary);

            exportStage.setTitle("Travel Maker - 選擇檔案匯出格式");
            exportStage.setResizable(false);
            exportStage.setScene(new Scene(root));
            exportStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
