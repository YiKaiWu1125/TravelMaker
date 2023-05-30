package ntou.cs.java2023.travelmaker;
import java.util.ArrayList;


public class TravelItinerary {//旅遊行程
    private ArrayList<Attractions> attractionslist = new ArrayList<Attractions>();
    ExportFile exportFile = new ExportFileWord();
    TravelItinerary(){

    }
    public void addAttraction(Attractions attractions){
        attractionslist.add(attractions);
    }
    public ArrayList<Attractions> getAttractionslist(){
        return attractionslist;
    }
    public Attractions getAttractions(int index){return attractionslist.get(index);}
    public void removeAttractions(int index){
        attractionslist.remove(index);
    }
    public void removeAttractions(Attractions attractions){
        attractionslist.remove(attractions);
    }
    public void setBeginTime(int index, TimeData timeData){
        Attractions attractions = attractionslist.get(index);
        attractions.setBeginTime(timeData);
        attractionslist.set(index,attractions);
    }
    public void setEndTime(int index, TimeData timeData){
        Attractions attractions = attractionslist.get(index);
        attractions.setEndTime(timeData);
        attractionslist.set(index,attractions);
    }
    public void setBooking(int index,boolean isbooking){
        Attractions attractions = attractionslist.get(index);
        attractions.setIsBooking(isbooking);
        attractionslist.set(index,attractions);
    }
    public void setExportType(ExportFile exportFile){
        this.exportFile = exportFile;
    }
    public void runExport(){
        exportFile.run(attractionslist);
    }

}
