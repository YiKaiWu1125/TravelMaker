package ntou.cs.java2023.travelmaker;
public class OkgoAttractionsItinerary extends AttractionsItinerary { //完全台灣 景點行程
    OkgoAttractionsItinerary(){
        super();
    }
    OkgoAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price){
        super(attractions, address, phone, businessTime, price);
    }
    public static String getFrontUrl(){
        return "https://guide.easytravel.com.tw/search/?&s_key=";
    }
    public static String getBackUrl(){
        return "";
    }
}
