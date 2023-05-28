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
    public void setTime(int index,int year,int month,int day,int hour,int minute){
        Attractions attractions = attractionslist.get(index);
        attractions.setDate(year,month,day);
        attractions.setHour(hour);
        attractions.setMinute(minute);
        attractionslist.set(index,attractions);
    }
    public void setBooking(int index,boolean isbooking){
        Attractions attractions = attractionslist.get(index);
        attractions.isBooking(isbooking);
        attractionslist.set(index,attractions);
    }
    public void setExportType(ExportFile exportFile){
        this.exportFile = exportFile;
    }
    public void runExport(){
        exportFile.run(attractionslist);
    }
}
