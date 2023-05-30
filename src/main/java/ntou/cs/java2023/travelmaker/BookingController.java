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

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingController implements Initializable {
    @FXML
    private Button bookingBackButton;
    @FXML
    private Button bookingNextButton;
    @FXML
    private Button bookingShowButton;
    @FXML
    private Button botButton;
    @FXML
    private TableView<Attractions> bookingTable;
    @FXML
    private TableColumn<Attractions, String> attractionColumn;
    @FXML
    private TableColumn<Attractions, Button> kkdayColumn;
    @FXML
    private TableColumn<Attractions, Button> klookColumn;
    @FXML
    private TableColumn<Attractions, Button> ezTravelColumn;
    @FXML
    private TableColumn<Attractions, CheckBox> isBookingColumn;
    private TravelItinerary cartTravelItinerary;
    private ArrayList<Attractions> attractionsList;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        attractionColumn.setCellValueFactory(new PropertyValueFactory<>("attractions"));
        kkdayColumn.setCellValueFactory(new PropertyValueFactory<>("kkdayButton"));
        klookColumn.setCellValueFactory(new PropertyValueFactory<>("klookButton"));
        ezTravelColumn.setCellValueFactory(new PropertyValueFactory<>("ezTravelButton"));
        isBookingColumn.setCellValueFactory(new PropertyValueFactory<>("isBookingCheckBox"));

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
                        setAlignment(Pos.CENTER);
                    }
                }
            };
        });
        kkdayColumn.setCellFactory(new Callback<TableColumn<Attractions, Button>, TableCell<Attractions, Button>>() {
            @Override
            public TableCell<Attractions, Button> call(TableColumn<Attractions, Button> param) {
                return new TableCell<Attractions, Button>() {
                    @Override
                    protected void updateItem(Button button, boolean empty) {
                        super.updateItem(button, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            Attractions attractions = getTableView().getItems().get(getIndex());
                            Hyperlink hyperlink = new Hyperlink();
                            button.setOnAction(event -> {
                                String url = "https://www.kkday.com/zh-tw/product/productlist?page=1&keyword=" + attractions.getAttractions();
                                try {
                                    Desktop.getDesktop().browse(new URI(url));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                            setGraphic(button);
                            setAlignment(Pos.CENTER);
                        }
                    }
                };
            }
        });

        klookColumn.setCellFactory(new Callback<TableColumn<Attractions, Button>, TableCell<Attractions, Button>>() {
            @Override
            public TableCell<Attractions, Button> call(TableColumn<Attractions, Button> param) {
                return new TableCell<Attractions, Button>() {
                    @Override
                    protected void updateItem(Button button, boolean empty) {
                        super.updateItem(button, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            Attractions attractions = getTableView().getItems().get(getIndex());
                            Hyperlink hyperlink = new Hyperlink();
                            button.setOnAction(event -> {
                                String url = "https://www.klook.com/zh-TW/search/result/?query=" + attractions.getAttractions();
                                try {
                                    Desktop.getDesktop().browse(new URI(url));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                            setGraphic(button);
                            setAlignment(Pos.CENTER);
                        }
                    }
                };
            }
        });

        ezTravelColumn.setCellFactory(new Callback<TableColumn<Attractions, Button>, TableCell<Attractions, Button>>() {
            @Override
            public TableCell<Attractions, Button> call(TableColumn<Attractions, Button> param) {
                return new TableCell<Attractions, Button>() {
                    @Override
                    protected void updateItem(Button button, boolean empty) {
                        super.updateItem(button, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            Attractions attractions = getTableView().getItems().get(getIndex());
                            Hyperlink hyperlink = new Hyperlink();
                            button.setOnAction(event -> {
                                String url = "https://trip.eztravel.com.tw/domestic/keywords?depart=TPE&kw=" + attractions.getAttractions();
                                try {
                                    Desktop.getDesktop().browse(new URI(url));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                            setGraphic(button);
                            setAlignment(Pos.CENTER);
                        }
                    }
                };
            }
        });

        isBookingColumn.setCellFactory(new Callback<TableColumn<Attractions, CheckBox>, TableCell<Attractions, CheckBox>>() {
            @Override
            public TableCell<Attractions, CheckBox> call(TableColumn<Attractions, CheckBox> param) {
                return new TableCell<Attractions, CheckBox>() {
                    @Override
                    protected void updateItem(CheckBox checkBox, boolean empty) {
                        super.updateItem(checkBox, empty);

                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(checkBox);
                            setAlignment(Pos.CENTER);
                        }
                    }
                };
            }
        });

        bookingTable.setFixedCellSize(50.0);

    }


    public void setCartTravelItinerary(TravelItinerary cartTravelItinerary){
        this.cartTravelItinerary = cartTravelItinerary;
    }

    @FXML
    private void clickBookingShowButton(ActionEvent event) {
        attractionsList = cartTravelItinerary.getAttractionslist();

        ObservableList<Attractions> data = FXCollections.observableArrayList(attractionsList);
        bookingTable.setItems(data);
    }

    @FXML
    private void clickBookingBackButton(ActionEvent event) {
        try {
            Stage currentStage = (Stage) bookingBackButton.getScene().getWindow();
            currentStage.close();

            Stage cartStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart-view.fxml"));
            Parent root = loader.load();
            CartController cartController = loader.getController();
            cartController.setCartTravelItinerary(cartTravelItinerary);

            cartStage.setTitle("Travel Maker - 購物車");
            cartStage.setResizable(false);
            cartStage.setScene(new Scene(root));
            cartStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickBookingNextButton(ActionEvent event) {
        try {
            if(attractionsList != null) {
                for(Attractions attractions : attractionsList){
                    if(attractions.getAddOne().isSelected()){
                        attractions.setIsBooking(true);
                    }
                }
            }
            Stage currentStage = (Stage) bookingNextButton.getScene().getWindow();
            currentStage.close();

            Stage exportStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("export-view.fxml"));
            Parent root = loader.load();
            ExportController exportController = loader.getController();
            exportController.setCartTravelItinerary(cartTravelItinerary);

            exportStage.setTitle("Travel Maker - 選擇檔案匯出格式");
            exportStage.setResizable(false);
            exportStage.setScene(new Scene(root));
            exportStage.show();

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
