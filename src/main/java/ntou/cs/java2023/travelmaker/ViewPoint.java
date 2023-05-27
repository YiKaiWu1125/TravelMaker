package ntou.cs.java2023.travelmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class ViewPoint {
    private String attraction;
    private String address;
    private String phone;
    private String businessTime;
    private String price;
    @FXML
    private Button addOne;

    public ViewPoint(String attraction, String address, String phone, String businessTime, String price) {
        this.attraction = attraction;
        this.address = address;
        this.phone = phone;
        this.businessTime = businessTime;
        this.price = price;

        addOne = new Button();
        addOne.setStyle("-fx-background-image: url('/static/images/cart.png'); -fx-background-repeat: no-repeat; -fx-background-size: 30px 30px; -fx-border-color: #f2be5c; -fx-border-width: 3; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-background-color: #FFFFFF; -fx-background-position: center;");
        addOne.setPrefWidth(40.0);
        addOne.setPrefHeight(40.0);
    }

    public ViewPoint(String attraction, String address, String phone, String businessTime) {
        this.attraction = attraction;
        this.address = address;
        this.phone = phone;
        this.businessTime = businessTime;
        setPrice();

        addOne = new Button();
        addOne.setStyle("-fx-background-image: url('/static/images/cart.png'); -fx-background-repeat: no-repeat; -fx-background-size: 30px 30px; -fx-border-color: #f2be5c; -fx-border-width: 3; -fx-background-radius: 5px; -fx-border-radius: 5px; -fx-background-color: #FFFFFF; -fx-background-position: center;");
        addOne.setPrefWidth(40.0);
        addOne.setPrefHeight(40.0);
    }

    public String getAttraction() {
        return attraction;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public String getPrice() {
        return price;
    }

    public Button getAddOne() {
        return addOne;
    }

    public void setPrice(){
        this.price = "";
    }
}
