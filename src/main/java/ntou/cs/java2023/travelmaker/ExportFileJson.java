package ntou.cs.java2023.travelmaker;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ExportFileJson extends ExportFile{
    @Override
    public void run(ArrayList<Attractions> attractionsList){
        JSONArray jsonArray = new JSONArray();
        int i = 0;
        for(Attractions attractions : attractionsList){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("attraction",attractions.getAttraction());
            jsonObject.put("address",attractions.getAddress());
            jsonObject.put("phone",attractions.getPhone());
            jsonObject.put("BbsinessTime",attractions.getBusinessTime());
            jsonObject.put("price",attractions.getPrice());
            jsonObject.put("source",attractions.getSource());
            jsonObject.put("isBooking",attractions.getIsBooking());
            jsonObject.put("beginTime",attractions.getBeginTime());
            jsonObject.put("endTime",attractions.getEndTime());
            jsonArray.add(jsonObject);
        }

        try (FileWriter fileWriter = new FileWriter("output.json")) {
            // 寫入檔案
            fileWriter.write(jsonArray.toJSONString());
            System.out.println("JSON檔案匯出成功！");
        } catch (IOException e) {
            System.out.println("發生IO錯誤：" + e.getMessage());
        }
    }
}
