package ntou.cs.java2023.travelmaker;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import com.google.gson.Gson;
import java.io.FileReader;


public class StartController {

    @FXML
    private Button startButton;
    @FXML
    private Button openButton;
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

    @FXML
    private void clickOpenButton(ActionEvent event) {
        try {
            ReadFile readFile = new ReadFileJson();
            cartTravelItinerary =  readFile.run("output.json");
            System.out.println(cartTravelItinerary.getAttractionslist());

            Stage currentStage = (Stage) startButton.getScene().getWindow();
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
}