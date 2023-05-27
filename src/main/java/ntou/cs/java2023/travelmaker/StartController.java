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

    @FXML
    private void clickStartButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) startButton.getScene().getWindow();
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