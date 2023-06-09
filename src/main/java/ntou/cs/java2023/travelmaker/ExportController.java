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
    private Button pdfButton;
    @FXML
    private Button wordButton;
    @FXML
    private Button excelButton;
    @FXML
    private Button jsonButton;
    private TravelItinerary cartTravelItinerary;

    public void setCartTravelItinerary(TravelItinerary cartTravelItinerary) {
        this.cartTravelItinerary = cartTravelItinerary;
    }

    @FXML
    private void clickExportBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) exportBackButton.getScene().getWindow();
            currentStage.close();

            Stage cartStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("booking-view.fxml"));
            Parent root = loader.load();
            BookingController bookingController = loader.getController();
            bookingController.setCartTravelItinerary(cartTravelItinerary);

            cartStage.setTitle("Travel Maker - 來訂票吧~");
            cartStage.setResizable(false);
            cartStage.setScene(new Scene(root));
            cartStage.show();

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
    private void clickPdfButton() {
        cartTravelItinerary.setExportType(new ExportFilePdf());
        cartTravelItinerary.runExport();
    }
    @FXML
    private void clickWordButton() {
        cartTravelItinerary.setExportType(new ExportFileWord());
        cartTravelItinerary.runExport();
    }
    @FXML
    private void clickExcelButton() {
        cartTravelItinerary.setExportType(new ExportFileExcel());
        cartTravelItinerary.runExport();
    }
    @FXML
    private void clickJsonButton() {
        cartTravelItinerary.setExportType(new ExportFileJson());
        cartTravelItinerary.runExport();
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
