package ntou.cs.java2023.travelmaker;
public class TwInfoAttractionsItinerary extends AttractionsItinerary {//台灣景點資訊 景點行程
    TwInfoAttractionsItinerary(){
        super();
    }
    TwInfoAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price){
        super(attractions, address, phone, businessTime, price);
    }
}
