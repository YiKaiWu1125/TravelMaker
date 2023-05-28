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
    private Button exportFinishedButton;

    @FXML
    private void clickExportBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) exportBackButton.getScene().getWindow();
            currentStage.close();

            Stage searchStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("cart-view.fxml"));
            searchStage.setTitle("Travel Maker - Go Where?");
            searchStage.setResizable(false);
            searchStage.setScene(new Scene(root));
            searchStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @FXML
//    private void clickExportFinishedButton(ActionEvent event) {
//        // Create Window Dialog
//        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.setTitle("完成檔案匯出！");
//        dialog.setHeaderText("真的要離開嗎QAQ");
//
//        DialogPane dialogPane = dialog.getDialogPane();
//
//        // Set dialog css Form
//        dialogPane.getStylesheets().add(getClass().getResource("/static/css/dialog.css").toExternalForm());
//        dialogPane.getStylesheets().add(getClass().getResource("/static/css/button.css").toExternalForm());
//
//        // Create Close Window Button
//        ButtonType closeWindowButtonType = new ButtonType("結束", ButtonBar.ButtonData.CANCEL_CLOSE);
//        dialog.getDialogPane().getButtonTypes().add(closeWindowButtonType);
//        Button closeWindowButton = (Button) dialog.getDialogPane().lookupButton(closeWindowButtonType);
//        closeWindowButton.getStyleClass().add("normalButton"); // Set button styleClass
//
//        // Create Back To search-view Button
//        ButtonType backToSearchButtonType = new ButtonType("回到首頁", ButtonBar.ButtonData.OK_DONE);
//        dialog.getDialogPane().getButtonTypes().add(backToSearchButtonType);
//        Button backToSearchButton = (Button) dialog.getDialogPane().lookupButton(backToSearchButtonType);
//        backToSearchButton.getStyleClass().add("normalButton"); // Set button styleClass
//
//        // 監聽按鈕的點擊事件
//        dialog.setOnCloseRequest(event1 -> {
//            ButtonType result = dialog.getResult();
//            if (result == backToSearchButtonType) {
//                // 返回按鈕的事件處理
//                try {
//                    Stage currentStage = (Stage) exportFinishedButton.getScene().getWindow();
//                    currentStage.close();
//
//                    Stage searchStage = new Stage();
//                    Parent root = FXMLLoader.load(getClass().getResource("search-view.fxml"));
//                    searchStage.setTitle("Travel Maker - Go Where?");
//                    searchStage.setResizable(false);
//                    searchStage.setScene(new Scene(root));
//                    searchStage.show();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else if (result == closeWindowButtonType) {
//                // 關閉系統
//                Platform.exit();
//            }
//        });
//        dialog.showAndWait(); // 顯示彈出視窗並等待用戶關閉
//    }
}
