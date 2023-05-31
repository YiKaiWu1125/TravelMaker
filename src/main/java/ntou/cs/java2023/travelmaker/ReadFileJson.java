package ntou.cs.java2023.travelmaker;

import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.T;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class ReadFileJson extends ReadFile{
    @Override
    public TravelItinerary run(String url){
        TravelItinerary travelItinerary = new TravelItinerary();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(url)) {
            System.out.println(url);
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray jsonArray = (JSONArray) jsonObject.get("TravelItinerary");
            for (Object studentObj : jsonArray) {
                JSONObject student = (JSONObject) studentObj;
    
                String attractions = (String)student.get("attractions");
                String address = (String)student.get("address");
                String phone = (String)student.get("phone");
                String businessTime = (String)student.get("businessTime");
                String price = (String)student.get("price");
                String source = (String)student.get("source");
                String isBookingStr = (String)student.get("isBooking");
                System.out.println(isBookingStr);
                boolean isBooking = isBookingStr.contains("尚未訂購")?false:true;

                JSONArray timeArray = (JSONArray) student.get("beginTime");
                TimeData beginTime = new TimeData((String) timeArray.get(0),(String) timeArray.get(1),(String) timeArray.get(2),(String) timeArray.get(3),(String) timeArray.get(4));

                timeArray = (JSONArray) student.get("endTime");
                TimeData endTime = new TimeData((String) timeArray.get(0),(String) timeArray.get(1),(String) timeArray.get(2),(String) timeArray.get(3),(String) timeArray.get(4));


                //System.out.println("attraction"+attraction);
                //System.out.println("address"+address);
                //System.out.println("phone"+phone);
                //System.out.println("BbsinessTime"+bsinessTime);
                //System.out.println("price"+price);
                //System.out.println("source"+source);
                //System.out.println("isBooking"+isBooking);
                //System.out.println("beginTime"+beginTime);
                //System.out.println("endTime"+endTime);

                if(source.contains("easytravel")){
                    travelItinerary.addAttraction(new EasyTravelAttractionsItinerary(attractions,address,phone,businessTime,price,source,isBooking,beginTime,endTime));
                }
                else if(source.contains("okgo")){
                    travelItinerary.addAttraction(new OkgoAttractionsItinerary(attractions,address,phone,businessTime,price,source,isBooking,beginTime,endTime));
                }
                else if(source.contains("zip5")){
                    travelItinerary.addAttraction(new TwInfoAttractionsItinerary(attractions,address,phone,businessTime,price,source,isBooking,beginTime,endTime));
                }
                else if(source.contains("自行新增")){
                    travelItinerary.addAttraction(new MyselfAttractionsItinerary(attractions,address,phone,businessTime,price,source,isBooking,beginTime,endTime));
                }
                else{
                    System.out.println("匯入時找不到景點型態");
                }
            }
            //System.out.println(travelItinerary);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return travelItinerary;
    }
}
