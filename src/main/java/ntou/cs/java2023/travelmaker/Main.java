package ntou.cs.java2023.travelmaker;

import javafx.util.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Spide s = new TwInfoSpide();
        //Spide s = new OkgoSpide();
        //Spide s = new EasyTravelSpide();
        //ArrayList<Pair<String, String>> arr = s.crawlerPlace("台中");
        //System.out.println(arr);
        //Attractions attractions = s.crawlerPlaceData(arr.get(0).getKey(),arr.get(0).getValue());
        //
        //System.out.println(attractions);


        ////使用
        //SearchTopTen STT = new SearchTopTen();
        //STT.search("台中");
        //ArrayList<Attractions> attractionsList = STT.getTopTen();
        ////印出
        //int i = 1;
        //for(Attractions attractions : attractionsList){
        //    System.out.printf("%d : %s  %s %s %s %s%n",i++,attractions.getAttraction(), attractions.getAddress(), attractions.getPhone(), attractions.getPrice(), attractions.getBusinessTime());
        //}
        ////可重複使用
        //STT.search("澎湖");
        //attractionsList= STT.getTopTen();
        ////印出
        //i = 1;
        //for(Attractions attractions : attractionsList){
        //    System.out.printf("%d : %s  %s %s %s %s%n",i++,attractions.getAttraction(), attractions.getAddress(), attractions.getPhone(), attractions.getPrice(), attractions.getBusinessTime());
        //}
        SearchTopTen STT = new SearchTopTen();
        STT.search("台中");
        ArrayList<Attractions> attractionsList = STT.getTopTen();
        TravelItinerary travelItinerary = new TravelItinerary();
        for(Attractions attractions : attractionsList){
            travelItinerary.addAttraction(attractions);
        }
        travelItinerary.setExportType(new ExportFilePdf());
        travelItinerary.runExport();
    }
}