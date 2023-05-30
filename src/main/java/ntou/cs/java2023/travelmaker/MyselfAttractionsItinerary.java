package ntou.cs.java2023.travelmaker;
public class MyselfAttractionsItinerary extends AttractionsItinerary {//自行建立景點行程
    MyselfAttractionsItinerary(){
        super("","","","","","自行新增");
    }
    MyselfAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price, String source){
        super(attractions, address, phone, businessTime, price, "自行新增");
    }
    MyselfAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price, String source, Boolean isBooking, TimeData beginTime, TimeData endTime){
        super(attractions, address, phone, businessTime, price, "自行新增", isBooking, beginTime, endTime);
    }
}
