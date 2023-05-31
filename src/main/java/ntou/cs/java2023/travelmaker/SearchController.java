package ntou.cs.java2023.travelmaker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.swing.text.View;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
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
    private Button botButton;
    @FXML
    private TableView<Attractions> attractionsTable;
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
    private TableColumn<Attractions, CheckBox> addOneColumn;
    @FXML
    private TableColumn<Attractions, String> sourceColumn;
    private ArrayList<Attractions> attractionsList = null;
    private TravelItinerary cartTravelItinerary;

    SearchTopTen searchTool = new SearchTopTen();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        attractionColumn.setCellValueFactory(new PropertyValueFactory<>("attractions"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        businessTimeColumn.setCellValueFactory(new PropertyValueFactory<>("businessTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        addOneColumn.setCellValueFactory(new PropertyValueFactory<>("addOne"));
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("source"));

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

        addOneColumn.setCellFactory(new Callback<TableColumn<Attractions, CheckBox>, TableCell<Attractions, CheckBox>>() {
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
                        }
                    }
                };
            }
        });

        sourceColumn.setCellFactory(column -> {
            return new TableCell<Attractions, String>() {
                private Hyperlink hyperlink;

                {
                    setWrapText(true);
                    setGraphic(null);
                }

                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        if (hyperlink == null) {
                            hyperlink = new Hyperlink();
                            hyperlink.setOnAction(event -> {
                                String url = hyperlink.getText();
                                openURL(url);
                            });
                        }

                        hyperlink.setText(item);
                        setGraphic(hyperlink);
                        setText(null);
                    }
                }

                // Open the URL using the system's default browser
                private void openURL(String url) {
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
        });
        attractionsTable.setFixedCellSize(200.0);
    }

    public TravelItinerary getCartTravelItinerary() {
        return this.cartTravelItinerary;
    }

    public void setCartTravelItinerary(TravelItinerary cartTravelItinerary) {
        this.cartTravelItinerary = cartTravelItinerary;
    }

    @FXML
    private void clickAddAttractionButton(ActionEvent event) {
        try {
            if(attractionsList != null) {
                for(Attractions attractions : attractionsList){
                    if(attractions.getAddOne().isSelected()){
                        cartTravelItinerary.addAttraction(attractions);
                    }
                }
            }

            Stage currentStage = (Stage) addAttractionButton.getScene().getWindow();
            currentStage.close();

            Stage addStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add-attraction-view.fxml"));
            Parent root = loader.load();
            AddAttractionController addAttractionController = loader.getController();
            addAttractionController.setCartTravelItinerary(cartTravelItinerary);

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
            if(attractionsList != null) {
                for(Attractions attractions : attractionsList){
                    if(attractions.getAddOne().isSelected()){
                        cartTravelItinerary.addAttraction(attractions);
                    }
                }
            }

            Stage currentStage = (Stage) cartButton.getScene().getWindow();
            currentStage.close();

            Stage cartStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cart-view.fxml"));
            Parent root = loader.load();
            CartController cartController = loader.getController();
            cartController.setCartTravelItinerary(cartTravelItinerary);
            CartController cartController1 = new CartController();
            cartController1.setCartTravelItinerary(cartTravelItinerary);

            cartStage.setTitle("Travel Maker - 購物車");
            cartStage.setResizable(false);
            cartStage.setScene(new Scene(root));
            cartStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickSearchButton(ActionEvent event) {

        if(attractionsList != null) {
            for(Attractions attractions : attractionsList){
                if(attractions.getAddOne().isSelected()){
                    cartTravelItinerary.addAttraction(attractions);
                }
            }
        }

        String searchText = searchTextField.getText();
        System.out.printf("Search Text: %s%n", searchText);

        searchTool.search(searchText);
        //開始搜尋 並回傳結果 型態為 ArrayList<Attractions>
        attractionsList = searchTool.getTopTen();

        ObservableList<Attractions> data = FXCollections.observableArrayList(attractionsList);
        attractionsTable.setItems(data);
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
