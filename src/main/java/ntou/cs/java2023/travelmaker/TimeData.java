package ntou.cs.java2023.travelmaker;

public class TimeData {
    private String year;
    private String month;
    private String day;
    private String hour;
    private String minute;
    private boolean isNull;
    TimeData(){
        this("","","","","");
        isNull = true;
    }
    TimeData(String year, String month,String day,String hour,String minute){
        setTime(year, month, day, hour, minute);
        isNull = false;
        if(year.length()<=0 ||month.length()<=0||day.length()<=0||hour.length()<=0||minute.length()<=0){
            isNull = true;
        }
    }
    public void setTime(String year, String month,String day,String hour,String minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    public String getYear(){
        return year;
    }
    public String getMonth(){
        return month;
    }
    public String getDay(){
        return day;
    }
    public String getHour(){
        return hour;
    }
    public String getMinute(){
        return minute;
    }
    public String toString(){
        return isNull?"尚未規劃時間":String.format("%s年%s月%s日 %s:%s",getYear(),getMonth(),getDay(),getHour(),getMinute());
    }
}
