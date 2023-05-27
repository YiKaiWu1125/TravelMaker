package ntou.cs.java2023.travelmaker;

import javafx.util.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwInfoSpide extends Spide{//爬蟲

    @Override
    public ArrayList<Pair<String, String>> crawlerPlace(String where){
        ArrayList<Pair<String, String>> placeName = new ArrayList<Pair<String, String>>();
        String url = "https://guide.easytravel.com.tw/search/?&s_key=" + where;
        placeName.add(new Pair<String, String>(where,where));
        //System.out.println(placeName);
        return placeName;
    }
    @Override
    public Attractions crawlerPlaceData(String place,String keyword ){//die 我做不到提取門票時間QQ
        String url = url = "http://zip5.5432.tw/poi/?name=" + keyword;
        String telephone = "";
        String address = "";
        String openTime = "";
        String ticket = "";
        Attractions attractions = null;
        //輔助
        try {

            Document doc = Jsoup.connect(url).get();
            Element poiDataDiv = doc.getElementById("poi-data");
            Elements titleElements = poiDataDiv.select("td.poi-data-title");
            Elements contentElements = poiDataDiv.select("td.poi-data-conetne");

            for (int i = 0; i < titleElements.size(); i++) {
                Element titleElement = titleElements.get(i);
                Element contentElement = contentElements.get(i);
                String title = titleElement.text();
                String content = contentElement.text();
                switch (title){
                    case "名稱" :
                        if(content!="")
                            place=content;
                        else place="無";
                        break;
                    case "電話" :
                        if(content!="")
                            telephone=content;
                        else telephone="無";
                        break;
                    case "地址" :
                        if(content!="")
                            address=content;
                        else address="無";
                        break;
                    case "開放時間" :
                        if(content!="")
                            openTime=content;
                        else openTime="無";
                        break;
                    default :
                        break;
                }
            }
            //output
            attractions = new TwInfoAttractionsItinerary(place,address,telephone,openTime,ticket);
            System.out.println("\n"+place);
            System.out.println("電話：" + telephone);
            System.out.println("地址：" + address);
            System.out.println("營業時間：" + openTime);
            System.out.println("門票："+ticket);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            System.err.println("找不到景點符合("+keyword+")的資料。");
            System.exit(1);
        }
        return attractions;
    }
}
