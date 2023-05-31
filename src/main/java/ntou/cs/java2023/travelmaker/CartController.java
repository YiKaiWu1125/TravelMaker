package ntou.cs.java2023.travelmaker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.apache.poi.ss.formula.functions.T;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CartController implements Initializable {

    @FXML
    private Button cartBackButton;
    @FXML
    private Button cartNextButton;
    @FXML
    private TableView<Attractions> travelItineraryTable;
    @FXML
    private TableColumn<Attractions, String> attractionColumn;
    @FXML
    private TableColumn<Attractions, String> addressColumn;
    @FXML
    private TableColumn<Attractions, String> phoneColumn;
    @FXML
    private TableColumn<Attractions, String> businessTimeColumn;
    @FXML
    private TableColumn<Attractions, String> priceColumn;
    @FXML
    private TableColumn<Attractions, Button> setTimeColumn;
    @FXML
    private TableColumn<Attractions, Button> deleteItemColumn;
    @FXML
    private TableColumn<Attractions, TimeData> startTimeColumn;
    @FXML
    private TableColumn<Attractions, TimeData> endTimeColumn;
    private TravelItinerary cartTravelItinerary;
    private ArrayList<Attractions> attractionsList;

    public CartController() {
        SearchController searchController = new SearchController();
        this.cartTravelItinerary = searchController.getCartTravelItinerary();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        attractionColumn.setCellValueFactory(new PropertyValueFactory<>("attractions"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        businessTimeColumn.setCellValueFactory(new PropertyValueFactory<>("businessTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        setTimeColumn.setCellValueFactory(new PropertyValueFactory<>("setTime"));
        deleteItemColumn.setCellValueFactory(new PropertyValueFactory<>("deleteItem"));
        startTimeColumn.setCellValueFactory(new PropertyValueFactory<>("beginTime"));
        endTimeColumn.setCellValueFactory(new PropertyValueFactory<>("endTime"));

        attractionColumn.setCellFactory(column -> {
            return new TableCell<Attractions, String>() {
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
            return new TableCell<Attractions, String>() {
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
            return new TableCell<Attractions, String>() {
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
            return new TableCell<Attractions, String>() {
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
            return new TableCell<Attractions, String>() {
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
            return new TableCell<Attractions, Button>() {
                @Override
                protected void updateItem(Button button, boolean empty) {
                    super.updateItem(button, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                        setAlignment(Pos.TOP_CENTER);
                        button.setOnAction(this::handleSetTimeButtonClick);  // 将按钮点击事件分配给方法
                    }
                }
                @FXML
                private void handleSetTimeButtonClick(ActionEvent event) {
                    Attractions attractions = getTableView().getItems().get(getIndex());

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

                    Optional<ButtonType> result = dialog.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        LocalDate startDate = startDatePicker.getValue();
                        int startHour = startHourComboBox.getValue();
                        int startMin = startMinuteComboBox.getValue();
                        LocalDate endDate = endDatePicker.getValue();
                        int endHour = endHourComboBox.getValue();
                        int endMin = endMinuteComboBox.getValue();

                        attractions.setBeginTime(new TimeData(String.valueOf(startDate.getYear()), String.valueOf(startDate.getMonthValue()), String.valueOf(startDate.getDayOfMonth()), String.valueOf(startHour), String.valueOf(startMin)));
                        attractions.setEndTime(new TimeData(String.valueOf(endDate.getYear()), String.valueOf(endDate.getMonthValue()), String.valueOf(endDate.getDayOfMonth()), String.valueOf(endHour), String.valueOf(endMin)));

                    }

                    //dialog.showAndWait();
                }
            };
        });

        deleteItemColumn.setCellFactory(column -> {
            return new TableCell<Attractions, Button>() {
                @Override
                protected void updateItem(Button button, boolean empty) {
                    super.updateItem(button, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(button);
                        setAlignment(Pos.TOP_CENTER);
                        button.setOnAction(this::handleDeleteItemClick);
                    }
                }
                @FXML
                private void handleDeleteItemClick(ActionEvent event) {
                    Attractions attractions = getTableView().getItems().get(getIndex());
                    cartTravelItinerary.removeAttractions(attractions);
                }

            };
        });

        startTimeColumn.setCellFactory(column -> {
            return new TableCell<Attractions, TimeData>() {
                @Override
                protected void updateItem(TimeData item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item.toString());
                        setWrapText(true);
                    }
                }
            };
        });

        endTimeColumn.setCellFactory(column -> {
            return new TableCell<Attractions, TimeData>() {
                @Override
                protected void updateItem(TimeData item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        setText(item.toString());
                        setWrapText(true);
                    }
                }
            };
        });

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

    public void clickCartShowButton(ActionEvent event) {
        attractionsList = cartTravelItinerary.getAttractionslist();

        ObservableList<Attractions> data = FXCollections.observableArrayList(attractionsList);
        travelItineraryTable.setItems(data);
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
