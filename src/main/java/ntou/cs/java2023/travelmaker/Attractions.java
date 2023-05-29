package ntou.cs.java2023.travelmaker;
public interface Attractions {   //景點
   public String getAttraction();
   public String getAddress();
   public String getPhone();
   public String getBusinessTime();
   public String getPrice();
   public String getSource();
   public String getIsBooking();
   public TimeData getBeginTime();
   public TimeData getEndTime();
   public void setBeginTime(TimeData beginTime);
   public void setEndTime(TimeData endTime);
   public void setIsBooking(boolean isBooking);
}