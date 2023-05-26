package ntou.cs.java2023.travelmaker;
public abstract class attractionsItinerary implements attractions { //景點行程
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

    private String url;
    public void attractionsItinerary(){
        year = month = day = hour = minute = 0;
        isBooking = false;
        attractions = address = phone = businessTime = price = null;
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
    public String getUrl(){
        return url;
    }
    @Override
    public void setUrl(String url){
        this.url = url;
    }
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
}
