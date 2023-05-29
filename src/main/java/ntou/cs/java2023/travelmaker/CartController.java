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
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private Button cartBackButton;
    @FXML
    private Button cartNextButton;
    @FXML
    private ComboBox<Integer> hourComboBox;
    @FXML
    private ComboBox<Integer> minuteComboBox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        hourComboBox.setItems(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23));
        hourComboBox.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return String.format("%02d", object);
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        });

        minuteComboBox.setItems(FXCollections.observableArrayList(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55));
        minuteComboBox.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return String.format("%02d", object);
            }

            @Override
            public Integer fromString(String s) {
                return Integer.parseInt(s);
            }
        });

    }

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
