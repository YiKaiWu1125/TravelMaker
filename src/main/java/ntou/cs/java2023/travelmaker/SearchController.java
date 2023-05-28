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

public class SearchController implements Initializable{

    @FXML
    private TextField searchTextField;
    @FXML
    private Button searchButton;
    @FXML
    private Button addAttractionButton;
    @FXML
    private Button cartButton;
    @FXML
    private TableView<ViewPoint> attractionsTable;
    @FXML
    private TableColumn<ViewPoint, String> attractionColumn;
    @FXML
    private TableColumn<ViewPoint, String> addressColumn;
    @FXML
    private TableColumn<ViewPoint, String> phoneColumn;
    @FXML
    private TableColumn<ViewPoint, String> businessTimeColumn;
    @FXML
    private TableColumn<ViewPoint, String> priceColumn;
    @FXML
    private TableColumn<ViewPoint, Button> addOneColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        attractionColumn.setCellValueFactory(new PropertyValueFactory<>("attraction"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        businessTimeColumn.setCellValueFactory(new PropertyValueFactory<>("businessTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        addOneColumn.setCellValueFactory(new PropertyValueFactory<>("addOne"));

        attractionColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item);
                        setWrapText(true);
                    }
                }
            };
        });

        addressColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item);
                        setWrapText(true);
                    }
                }
            };
        });

        phoneColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item);
                        setWrapText(true);
                    }
                }
            };
        });

        businessTimeColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item);
                        setWrapText(true);
                    }
                }
            };
        });

        priceColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item);
                        setWrapText(true);
                    }
                }
            };
        });

        addOneColumn.setCellFactory(new Callback<>() {
            @Override
            public TableCell<ViewPoint, Button> call(TableColumn<ViewPoint, Button> param) {
                return new TableCell<>() {
                    @Override
                    protected void updateItem(Button button, boolean empty) {
                        super.updateItem(button, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(button);
                        }
                    }
                };
            }
        });

        attractionsTable.setItems(FXCollections.observableArrayList(
                new ViewPoint("台北市立動物園．木柵動物園", "台北市文山區新光路2段30號", "022938-2300#630", "9:00~17:00（16:00停止入園），部分展館週一休館", "全票：60, 優待票：30, 團體票：42, 免費票：0, 教育中心-全票：20, 教育中心-優待票：10, 教育中心-免費票：0, 園區專車：5"),
                new ViewPoint("台北行天宮", "台北市中山區民權東路二段109號", "(02)2502-7924", "04:00~22:30"),
                new ViewPoint("台北龍山寺","台北市萬華區廣州街211號", "(02)2302-5162", "06:00~22:00"),
                new ViewPoint("台北101大樓", "台北市信義區市府路45號", "02-81018800", "購物中心-平日:11:00~21:30/假日:11:00~22:00 觀景台-9:00~22:00"),
                new ViewPoint("台北小巨蛋", "台北市松山區南京東路四段2號", "02-2181-2345", "全日開放"),
                new ViewPoint("台北忠烈祠", "台北市中山區北安路139號", "(02)2885-4162", "09:00~17:00"),
                new ViewPoint("台北植物園", "臺北市中正區南海路53號", "(02)2303-9978", "04:00~22:00", "免費參觀：0"),
                new ViewPoint("台北太平洋SOGO百貨-忠孝館", "台北市大安區忠孝東路四段45號", "0800-212002", "平時及例假日11:00~21:30 例假日前一天11:00~22:00"),
                new ViewPoint("台北當代藝術館", "臺北市大同區長安西路39號", "(02)2552-3721", "週二至週日10:00~18:00，下午5:30停止售票", "全票：50, 優待票：45, 團體票：40, 免費票：0"),
                new ViewPoint("台北轉運站", "台北市大同區市民大道一段209號", "02-77335888", "全日開放，商店依各店家營業時間。")
        ));
        attractionsTable.setFixedCellSize(150.0);
    }

    @FXML
    private void clickAddAttractionButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) addAttractionButton.getScene().getWindow();
            currentStage.close();

            Stage addStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("add-attraction-view.fxml"));
            addStage.setTitle("Travel Maker - 新增景點");
            addStage.setResizable(false);
            addStage.setScene(new Scene(root));
            addStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickCartButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cartButton.getScene().getWindow();
            currentStage.close();

            Stage addStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("cart-view.fxml"));
            addStage.setTitle("Travel Maker - 購物車");
            addStage.setResizable(false);
            addStage.setScene(new Scene(root));
            addStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
