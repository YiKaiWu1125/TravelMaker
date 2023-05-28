package ntou.cs.java2023.travelmaker;
public abstract class AttractionsItinerary implements Attractions { //景點行程
    private String attractions;
    private String address;
    private String phone;
    private String businessTime;
    private  String price;
    private boolean isBooking;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    AttractionsItinerary(){
        year = month = day = hour = minute = 0;
        isBooking = false;
        attractions = address = phone = businessTime = price = "";
    }
    AttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price){
        year = month = day = hour = minute = 0;
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
    public void setHour(int hour) {
        this.hour = hour;
    }
    @Override
    public void setMinute(int minute){
        this.minute = minute;
    }
    @Override
    public void setDate(int year, int month, int day){
        this.day = day;
    }
    @Override
    public void isBooking(boolean isBooking){
        this.isBooking = isBooking;
    }
    @Override
    public String toString(){
        String s = "";
        s += String.format("\n%s\n",this.getAttraction());
        s += String.format("地址：%s\n", this.getAddress());
        s += String.format("電話：%s\n", this.getPhone());
        s += String.format("營業時間：%s\n", this.getBusinessTime());
        s += String.format("門票：%s\n", this.getPrice());
        s += "              ";
        System.out.println(s);
        return s;
    }
}
