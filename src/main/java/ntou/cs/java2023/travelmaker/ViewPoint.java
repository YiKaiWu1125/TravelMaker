package ntou.cs.java2023.travelmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Font;

public class ViewPoint {
    private String attraction;
    private String address;
    private String phone;
    private String businessTime;
    private String price;
    @FXML
    private CheckBox addOne;

    public ViewPoint(String attraction, String address, String phone, String businessTime, String price) {
        this.attraction = attraction;
        this.address = address;
        this.phone = phone;
        this.businessTime = businessTime;
        this.price = price;

        addOne = new CheckBox();
        addOne.getStyleClass().add("check-box");
    }

    public ViewPoint(String attraction, String address, String phone, String businessTime) {
        this.attraction = attraction;
        this.address = address;
        this.phone = phone;
        this.businessTime = businessTime;
        setPrice();

        addOne = new CheckBox();
        addOne.getStyleClass().add("check-box");
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

    public void setPrice(){
        this.price = "";
    }

    public void setAddOne(boolean selected){
        addOne.setSelected(selected);
    }
}
