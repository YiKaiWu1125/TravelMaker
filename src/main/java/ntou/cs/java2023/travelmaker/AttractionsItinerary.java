package ntou.cs.java2023.travelmaker;
import javax.swing.*;
public abstract class AttractionsItinerary implements Attractions { //景點行程
    private String attractions;
    private String address;
    private String phone;
    private String businessTime;
    private  String price;
    private boolean isBooking;
    private TimeData beginTime;
    private TimeData endTime;
    private JCheckBox checkBox = new JCheckBox("");

    AttractionsItinerary(){
        this("","","","","");
    }
    AttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price){
        beginTime = endTime = new TimeData();
        isBooking = false;
        this.attractions = attractions; 
        this.address = address; 
        this.phone = phone; 
        this.businessTime = businessTime; 
        this.price = price; 
    }
    @Override
    public String getAttraction() {
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
    public String toString(){
        String s = "";
        s += String.format("\n%s\n",this.getAttraction());
        s += String.format("預計行程時間%s ~ %s\n",this.getBeginTime(),this.getEndTime());
        s += String.format("地址：%s\n", this.getAddress());
        s += String.format("電話：%s\n", this.getPhone());
        s += String.format("營業時間：%s\n", this.getBusinessTime());
        s += String.format("門票：%s\n", this.getPrice());
        s += "              ";
        System.out.println(s);
        return s;
    }
}
