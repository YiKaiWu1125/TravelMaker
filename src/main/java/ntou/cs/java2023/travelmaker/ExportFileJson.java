package ntou.cs.java2023.travelmaker;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExportFileJson extends ExportFile{
    @Override
    public void run(ArrayList<Attractions> attractionsList){
        // 创建 JSON 对象
        JSONArray jsonArray = new JSONArray();

        for (Attractions attractions : attractionsList){
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("attraction",attractions.getAttraction());
            jsonObject.put("address",attractions.getAddress());
            jsonObject.put("phone",attractions.getPhone());
            jsonObject.put("bsinessTime",attractions.getBusinessTime());
            jsonObject.put("price",attractions.getPrice());
            jsonObject.put("source",attractions.getSource());
            jsonObject.put("isBooking",attractions.getIsBooking());

            JSONArray timeJsonArray = new JSONArray();
            timeJsonArray.add(attractions.getBeginTime().getYear());
            timeJsonArray.add(attractions.getBeginTime().getMonth());
            timeJsonArray.add(attractions.getBeginTime().getDay());
            timeJsonArray.add(attractions.getBeginTime().getHour());
            timeJsonArray.add(attractions.getBeginTime().getMinute());
            jsonObject.put("beginTime",timeJsonArray);

            timeJsonArray = new JSONArray();
            timeJsonArray.add(attractions.getEndTime().getYear());
            timeJsonArray.add(attractions.getEndTime().getMonth());
            timeJsonArray.add(attractions.getEndTime().getDay());
            timeJsonArray.add(attractions.getEndTime().getHour());
            timeJsonArray.add(attractions.getEndTime().getMinute());
            jsonObject.put("endTime",timeJsonArray);

            jsonArray.add(jsonObject);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("TravelItinerary", jsonArray);

        try (FileWriter fileWriter = new FileWriter("output.json")) {
            fileWriter.write(jsonObject.toJSONString());
            fileWriter.flush();
            System.out.println("JSON写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
