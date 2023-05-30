package ntou.cs.java2023.travelmaker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private AnchorPane searchAnchorPane;

    @FXML
    private Button startButton;
    private TravelItinerary cartTravelItinerary;

    @FXML
    private void clickStartButton(ActionEvent event) {
        try {
            cartTravelItinerary = new TravelItinerary();

            Stage currentStage = (Stage) startButton.getScene().getWindow();
            currentStage.close();

            Stage searchStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search-view.fxml"));
            Parent root = loader.load();
            SearchController searchController = loader.getController();
            searchController.setCartTravelItinerary(cartTravelItinerary);

            searchStage.setTitle("Travel Maker - Go Where?");
            searchStage.setResizable(false);
            searchStage.setScene(new Scene(root));
            searchStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}