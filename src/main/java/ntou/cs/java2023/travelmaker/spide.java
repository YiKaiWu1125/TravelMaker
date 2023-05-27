package ntou.cs.java2023.travelmaker;

import javafx.util.Pair;

import java.util.ArrayList;

public abstract class Spide {//爬蟲

    public abstract ArrayList<Pair<String, String>> crawlerPlace(String where) ;
    public abstract Attractions crawlerPlaceData(String place, String keyword ) ;

}
