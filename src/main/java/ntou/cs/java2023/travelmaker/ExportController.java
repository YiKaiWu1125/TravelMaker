package ntou.cs.java2023.travelmaker;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.SplittableRandom;

public class ExportController {

    @FXML
    private Button exportBackButton;
    @FXML
    private Button exportBackToIndexButton;

    @FXML
    private void clickExportBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) exportBackButton.getScene().getWindow();
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
    private void clickExportBackToIndexButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) exportBackToIndexButton.getScene().getWindow();
            currentStage.close();

            Stage searchStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("search-view.fxml"));
            searchStage.setTitle("Travel Maker - Go Where?");
            searchStage.setResizable(false);
            searchStage.setScene(new Scene(root));
            searchStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
