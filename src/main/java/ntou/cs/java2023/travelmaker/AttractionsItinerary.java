package ntou.cs.java2023.travelmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public abstract class AttractionsItinerary implements Attractions { //景點行程
    private String attractions;
    private String address;
    private String phone;
    private String businessTime;
    private String price;
    private String source;
    private boolean isBooking;
    private TimeData beginTime;
    private TimeData endTime;
    @FXML
    private CheckBox addOne;
    @FXML
    private Button setTime;
    @FXML
    private Button deleteItem;
    @FXML
    private Button kkdayButton;
    @FXML
    private Button klookButton;
    @FXML
    private Button ezTravelButton;
    @FXML
    private CheckBox isBookingCheckBox;

    AttractionsItinerary(){
        this("","","","","", "");
    }
    AttractionsItinerary(String attractions,String address ,String phone ,String businessTime ,String price, String source){
        beginTime = endTime = new TimeData();
        isBooking = false;
        this.attractions = attractions; 
        this.address = address; 
        this.phone = phone; 
        this.businessTime = businessTime; 
        this.price = price;
        this.source = source;

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

        kkdayButton = new Button();
        kkdayButton.getStyleClass().add("normalButton");
        kkdayButton.setText("KKday");

        klookButton = new Button();
        klookButton.getStyleClass().add("normalButton");
        klookButton.setText("Klook");

        ezTravelButton = new Button();
        ezTravelButton.getStyleClass().add("normalButton");
        ezTravelButton.setText("易遊網");

        isBookingCheckBox = new CheckBox();
        isBookingCheckBox.getStyleClass().add("check-box");
    }
    AttractionsItinerary(String attractions,String address ,String phone ,String businessTime ,String price, String source, Boolean isBooking, TimeData beginTime, TimeData endTime){
        this(attractions,address,phone,businessTime,price,source);
        this.isBooking = isBooking;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
    @Override
    public String getAttractions() {
        return attractions;
    }
    @Override
    public String getAddress(){
        return address;
    }
    @Override
    public String getPhone(){
        return phone;
    }
    @Override
    public String getBusinessTime(){
        return businessTime;
    }
    @Override
    public String getPrice(){
        return price;
    }
    @Override
    public String getSource(){
        return source;
    }
    @Override
    public String getIsBooking(){return isBooking?"訂購完成":"尚未訂購";}
    @Override
    public TimeData getBeginTime(){return beginTime;}
    @Override
    public TimeData getEndTime(){return endTime;}
    @Override
    public void setBeginTime(TimeData beginTime){
        this.beginTime = beginTime;
    }
    @Override
    public void setEndTime(TimeData endTime){
        this.endTime = endTime;
    }
    @Override
    public void setIsBooking(boolean isBooking){
        this.isBooking = isBooking;
    }
    @Override
    public CheckBox getAddOne(){return addOne;}
    @Override
    public Boolean compareTime(Attractions attractions){
        if(this.getBeginTime().getIsNull()){return false;}
        else if(this.getEndTime().getIsNull()){return false;}
        else if(attractions.getBeginTime().getIsNull()){return true;}
        else if(attractions.getEndTime().getIsNull()){return true;}
        else if(this.getBeginTime().compareTime(attractions.getBeginTime())){return true;}
        else {return false;}
    }
    @Override
    public Button getSetTime(){return setTime;}
    @Override
    public Button getDeleteItem(){return deleteItem;}
    @Override
    public Button getKlookButton() {
        return klookButton;
    }
    @Override
    public Button getKkdayButton() {
        return kkdayButton;
    }
    @Override
    public Button getEzTravelButton() {
        return ezTravelButton;
    }
    @Override
    public CheckBox getIsBookingCheckBox() {
        return isBookingCheckBox;
    }

    @Override
    public String toString(){
        String s = "";
        s += String.format("\n%s\n",this.getAttractions());
        s += String.format("預計行程時間%s ~ %s\n",this.getBeginTime(),this.getEndTime());
        s += String.format("地址：%s\n", this.getAddress());
        s += String.format("電話：%s\n", this.getPhone());
        s += String.format("營業時間：%s\n", this.getBusinessTime());
        s += String.format("門票：%s\n", this.getPrice());
        s += String.format("來源：%s\n", this.getSource());
        s += String.format("是否訂票：%s\n", this.getIsBooking());
        s += "              ";
        //System.out.println(s);
        return s;
    }
}
