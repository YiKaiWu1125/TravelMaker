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
    private TextField attractionTextField;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField phoneTextField;
    @FXML
    private TextField businessTimeTextField;
    @FXML
    private TextField priceTextField;

    private TravelItinerary cartTravelItinerary;

    public void setCartTravelItinerary(TravelItinerary cartTravelItinerary) {
        this.cartTravelItinerary = cartTravelItinerary;
    }

    @FXML
    private void clickCancelButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cancelButton.getScene().getWindow();
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
    private void clickSaveButton(ActionEvent event) {
        try {
            String attractionText = attractionTextField.getText();
            String addressText = addressTextField.getText();
            String phoneText = phoneTextField.getText();
            String businessTimeText = businessTimeTextField.getText();
            String priceText = priceTextField.getText();

            cartTravelItinerary.addAttraction(new MyselfAttractionsItinerary(attractionText,addressText,phoneText,businessTimeText,priceText,"自行新增"));

            Stage currentStage = (Stage) saveButton.getScene().getWindow();
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
    private void clickBotButton(ActionEvent event) throws IOException {
        Stage newWindow = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatgpt-view.fxml"));
        Parent root = loader.load();

        // 获取从FXML文件中加载的控制器实例
        ChatgptController controller = loader.getController();

        // 其他代码

        Scene scene = new Scene(root, 400, 300);
        newWindow.setScene(scene);
        newWindow.setTitle("Chat Room");
        newWindow.show();
        controller.getInputField().requestFocus();
    }

}
