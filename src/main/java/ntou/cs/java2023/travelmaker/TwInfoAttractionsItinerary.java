package ntou.cs.java2023.travelmaker;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.BlockingDeque;

public class TwInfoAttractionsItinerary extends AttractionsItinerary {//台灣景點資訊 景點行程
    TwInfoAttractionsItinerary(){
        super();
    }
    TwInfoAttractionsItinerary(String attractions,String address ,String phone ,String businessTime,String price, String source){
        super(attractions, address, phone, businessTime, price, source);
    }
    TwInfoAttractionsItinerary(String attractions, String address , String phone , String businessTime, String price, String source, Boolean isbooking, TimeData beginTime, TimeData endTime){
        super(attractions, address, phone, businessTime, price, source, isbooking, beginTime, endTime);
    }
}
