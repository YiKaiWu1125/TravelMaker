package ntou.cs.java2023.travelmaker;
public class EasyTravelAttractionsItinerary extends AttractionsItinerary { //四方旅遊 景點行程
    EasyTravelAttractionsItinerary(){
        super();
    }
    EasyTravelAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price){
        super(attractions, address, phone, businessTime, price);
    }
    public static String getFrontUrl(){
        return "https://guide.easytravel.com.tw/search/?&s_key=";
    }
    public static String getBackUrl(){
        return "";
    }
}