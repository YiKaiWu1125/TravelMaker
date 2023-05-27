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
public class AddAttractionController {

    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField attractionField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField businessTimeField;
    @FXML
    private TextField priceField;

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//    }

    @FXML
    private void clickCancelButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cancelButton.getScene().getWindow();
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
    private void clickSaveButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) saveButton.getScene().getWindow();
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
