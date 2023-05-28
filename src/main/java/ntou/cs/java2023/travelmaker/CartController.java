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
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.SplittableRandom;

public class CartController {

    @FXML
    private Button cartBackButton;
    @FXML
    private Button cartNextButton;

    @FXML
    private void clickCartBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cartBackButton.getScene().getWindow();
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

    @FXML
    private void clickCartNextButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cartNextButton.getScene().getWindow();
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