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
import javafx.scene.layout.*;
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
    private TableView<ViewPoint> travelItineraryTable;
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
    private TableColumn<ViewPoint, Button> setTimeColumn;
    @FXML
    private TableColumn<ViewPoint, Button> deleteItemColumn;
    private TravelItinerary cartTravelItinerary;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        attractionColumn.setCellValueFactory(new PropertyValueFactory<>("attraction"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        businessTimeColumn.setCellValueFactory(new PropertyValueFactory<>("businessTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        setTimeColumn.setCellValueFactory(new PropertyValueFactory<>("setTime"));
        deleteItemColumn.setCellValueFactory(new PropertyValueFactory<>("deleteItem"));

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

        setTimeColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, Button>() {
                @Override
                protected void updateItem(Button button, boolean empty) {
                    super.updateItem(button, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                        button.setOnAction(this::handleSetTimeButtonClick);  // 将按钮点击事件分配给方法
                    }
                }
                @FXML
                private void handleSetTimeButtonClick(ActionEvent event) {

                    Label startLabel = new Label("請選擇出發時間：");
                    DatePicker startDatePicker = new DatePicker();
                    ComboBox<Integer> startHourComboBox = new ComboBox<>();
                    ComboBox<Integer> startMinuteComboBox = new ComboBox<>();
                    Label endLabel = new Label("請選擇離開時間：");
                    DatePicker endDatePicker = new DatePicker();
                    ComboBox<Integer> endHourComboBox = new ComboBox<>();
                    ComboBox<Integer> endMinuteComboBox = new ComboBox<>();

                    startHourComboBox.setItems(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23));
                    startHourComboBox.setConverter(new StringConverter<Integer>() {
                        @Override
                        public String toString(Integer object) {
                            return String.format("%02d", object);
                        }

                        @Override
                        public Integer fromString(String s) {
                            return Integer.parseInt(s);
                        }
                    });

                    startMinuteComboBox.setItems(FXCollections.observableArrayList(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55));
                    startMinuteComboBox.setConverter(new StringConverter<Integer>() {
                        @Override
                        public String toString(Integer object) {
                            return String.format("%02d", object);
                        }

                        @Override
                        public Integer fromString(String s) {
                            return Integer.parseInt(s);
                        }
                    });

                    endHourComboBox.setItems(FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23));
                    endHourComboBox.setConverter(new StringConverter<Integer>() {
                        @Override
                        public String toString(Integer object) {
                            return String.format("%02d", object);
                        }

                        @Override
                        public Integer fromString(String s) {
                            return Integer.parseInt(s);
                        }
                    });

                    endMinuteComboBox.setItems(FXCollections.observableArrayList(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55));
                    endMinuteComboBox.setConverter(new StringConverter<Integer>() {
                        @Override
                        public String toString(Integer object) {
                            return String.format("%02d", object);
                        }

                        @Override
                        public Integer fromString(String s) {
                            return Integer.parseInt(s);
                        }
                    });

                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setTitle("請設置時間");
                    dialog.setHeaderText(null);

                    HBox hBox = new HBox(startLabel);
                    HBox hBox1 = new HBox(startDatePicker, startHourComboBox, startMinuteComboBox);
                    HBox hBox2 = new HBox(endLabel);
                    HBox hBox3 = new HBox(endDatePicker, endHourComboBox, endMinuteComboBox);
                    VBox vBox = new VBox(hBox, hBox1, hBox2, hBox3);
                    dialog.getDialogPane().setContent(vBox);

                    dialog.getDialogPane().getStylesheets().add(getClass().getResource("/static/css/alert.css").toExternalForm());
                    dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

                    dialog.showAndWait();
                }
            };
        });

        deleteItemColumn.setCellFactory(column -> {
            return new TableCell<ViewPoint, Button>() {
                @Override
                protected void updateItem(Button button, boolean empty) {
                    super.updateItem(button, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                        //button.setOnAction(this::handleDeleteItemClick);
                    }
                }

//                private void handleDeleteItemClick(ActionEvent event) {
//                    // 处理删除按钮点击事件的逻辑
//                    ViewPoint viewPoint = getTableView().getItems().get(getIndex());
//                    // 在这里执行删除逻辑，例如从列表中移除 viewPoint
//                }
            };
        });

        travelItineraryTable.setItems(FXCollections.observableArrayList(
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
        travelItineraryTable.setFixedCellSize(150.0);
    }

    public void setCartTravelItinerary(TravelItinerary cartTravelItinerary) {
        this.cartTravelItinerary = cartTravelItinerary;
    }

    @FXML
    private void clickCartBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cartBackButton.getScene().getWindow();
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
    private void clickCartNextButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) cartNextButton.getScene().getWindow();
            currentStage.close();

            Stage bookingStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("booking-view.fxml"));
            Parent root = loader.load();
            BookingController bookingController = loader.getController();
            bookingController.setCartTravelItinerary(cartTravelItinerary);

            bookingStage.setTitle("Travel Maker - 來訂票吧~");
            bookingStage.setResizable(false);
            bookingStage.setScene(new Scene(root));
            bookingStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
