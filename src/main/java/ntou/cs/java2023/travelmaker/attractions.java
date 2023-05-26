package ntou.cs.java2023.travelmaker;
public interface attractions {   //景點 
   public String getAttraction();
   public String getAddress();
   public String getPhone();
   public String getBusinessTime();
   public String getPrice();
   public String getUrl();
   public void setUrl(String url);
   public void setHour(int hour);
   public void setMinute(int Minute);
   public void setDate(int year, int month, int day);
   public void isBooking(boolean isBooking);
}