package ntou.cs.java2023.travelmaker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public interface Attractions {   //景點
   public String getAttractions();
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
   public CheckBox getAddOne();
   public Boolean compareTime(Attractions attractions);
   public Button getSetTime();
   public Button getDeleteItem();
   public Button getKkdayButton();
   public Button getKlookButton();
   public Button getEzTravelButton();
   public CheckBox getIsBookingCheckBox();
}