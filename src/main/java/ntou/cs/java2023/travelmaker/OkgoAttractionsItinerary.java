package ntou.cs.java2023.travelmaker;
public class OkgoAttractionsItinerary extends AttractionsItinerary { //完全台灣 景點行程
    OkgoAttractionsItinerary(){
        super();
    }
    OkgoAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price, String source){
        super(attractions, address, phone, businessTime, price, source);
    }
    OkgoAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price, String source, Boolean isbooking, TimeData beginTime, TimeData endTime){
        super(attractions, address, phone, businessTime, price, source, isbooking, beginTime, endTime);
    }
}
