package ntou.cs.java2023.travelmaker;

import javafx.util.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Spide s = new TwInfoSpide();
        //Spide s = new OkgoSpide();
        Spide s = new EasyTravelSpide();
        ArrayList<Pair<String, String>> arr = s.crawlerPlace("台中");
        System.out.println(arr);
        Attractions attractions = s.crawlerPlaceData(arr.get(0).getKey(),arr.get(0).getValue());

        System.out.println(attractions);
    }
}