package ntou.cs.java2023.travelmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ViewPoint {
    private String attraction;
    private String address;
    private String phone;
    private String businessTime;
    private String price;
    @FXML
    private CheckBox addOne;
    @FXML
    private Button setTime;
    @FXML
    private Button deleteItem;

    public ViewPoint(String attraction, String address, String phone, String businessTime, String price) {
        this.attraction = attraction;
        this.address = address;
        this.phone = phone;
        this.businessTime = businessTime;
        this.price = price;

        addOne = new CheckBox();
        addOne.getStyleClass().add("check-box");

        setTime = new Button();
        setTime.getStyleClass().add("set-time-button");
        setTime.setPrefWidth(50.0);
        setTime.setPrefHeight(50.0);

        deleteItem = new Button();
        deleteItem.getStyleClass().add("delete-button");
        deleteItem.setPrefWidth(50.0);
        deleteItem.setPrefHeight(50.0);
    }

    public ViewPoint(String attraction, String address, String phone, String businessTime) {
        this.attraction = attraction;
        this.address = address;
        this.phone = phone;
        this.businessTime = businessTime;
        setPrice();

        addOne = new CheckBox();
        addOne.getStyleClass().add("check-box");

        setTime = new Button();
        setTime.getStyleClass().add("set-time-button");
        setTime.setPrefWidth(50.0);
        setTime.setPrefHeight(50.0);

        deleteItem = new Button();
        deleteItem.getStyleClass().add("delete-button");
        deleteItem.setPrefWidth(50.0);
        deleteItem.setPrefHeight(50.0);
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

    public CheckBox getAddOne() {
        return addOne;
    }
    public Button getSetTime() {
        return setTime;
    }

    public Button getDeleteItem() {
        return deleteItem;
    }

    public void setPrice(){
        this.price = "";
    }

    public void setAddOne(boolean selected) {
        addOne.setSelected(selected);
    }
}
