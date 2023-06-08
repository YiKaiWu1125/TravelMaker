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
    public Boolean compareTime(TimeData timeData){
        if(Integer.valueOf(this.getYear()) > Integer.valueOf(timeData.getYear())){return true;}
        else if(Integer.valueOf(this.getYear()) < Integer.valueOf(timeData.getYear())){return false;}

        else if(Integer.valueOf(this.getMonth()) > Integer.valueOf(timeData.getMonth())){return true;}
        else if(Integer.valueOf(this.getMonth()) < Integer.valueOf(timeData.getMonth())){return false;}

        else if(Integer.valueOf(this.getDay()) > Integer.valueOf(timeData.getDay())){return true;}
        else if(Integer.valueOf(this.getDay()) < Integer.valueOf(timeData.getDay())){return false;}

        else if(Integer.valueOf(this.getHour()) > Integer.valueOf(timeData.getHour())){return true;}
        else if(Integer.valueOf(this.getHour()) < Integer.valueOf(timeData.getHour())){return false;}

        else if(Integer.valueOf(this.getMinute()) > Integer.valueOf(timeData.getMinute())){return true;}
        else if(Integer.valueOf(this.getMinute()) < Integer.valueOf(timeData.getMinute())){return false;}

        else {return false;}
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
    public Boolean getIsNull(){
        return isNull;
    }

    public String toString(){
        return isNull?"尚未規劃時間":String.format("%s年%s月%s日 %s:%s",getYear(),getMonth(),getDay(),getHour(),getMinute());
    }
}
