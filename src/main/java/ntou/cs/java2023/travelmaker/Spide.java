package ntou.cs.java2023.travelmaker;

import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Spide {//爬蟲
    private ArrayList<Attractions> attractionsList = new ArrayList<Attractions>();
    private String gowhere;
    Spide(String gowhere){
        this.gowhere = gowhere;
        ArrayList<Pair<String, String>> placeArr = crawlerPlace(gowhere);
        for(Pair<String,String> place : placeArr){
            attractionsList.add(crawlerPlaceData(place.getKey(),place.getValue()));
        }
    }
    public ArrayList<Attractions> getResult(){
        return attractionsList;
    }
    public abstract ArrayList<Pair<String, String>> crawlerPlace(String where) ;
    public abstract Attractions crawlerPlaceData(String place, String keyword ) ;
}
