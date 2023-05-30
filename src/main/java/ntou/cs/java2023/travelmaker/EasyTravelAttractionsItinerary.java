package ntou.cs.java2023.travelmaker;
public class EasyTravelAttractionsItinerary extends AttractionsItinerary { //四方旅遊 景點行程
    EasyTravelAttractionsItinerary(){
        super();
    }
    EasyTravelAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price,String source){
        super(attractions, address, phone, businessTime, price, source);
    }
    EasyTravelAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price,String source,Boolean isbooking,TimeData beginTime, TimeData endTime){
        super(attractions, address, phone, businessTime, price, source, isbooking ,beginTime, endTime);
    }
}
