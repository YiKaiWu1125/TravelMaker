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

public class EasyTravelSpide extends Spide{//四方爬蟲
    public ArrayList<Pair<String, String>> crawlerPlace(String where){
        ArrayList<Pair<String, String>> placeName = new ArrayList<Pair<String, String>>();
        String url =  "https://guide.easytravel.com.tw/search/?&s_key=" + where;
        try {

            Document doc = Jsoup.connect(url).get();
            Elements divs = doc.select("div.name");
            // 前十地點，name
            int i=0;
            for (Element div:divs) {

                Element link = div.selectFirst("a");
                String name = div.text();
                String href = link.attr("href");
                placeName.add(new Pair<String,String>(name,href));
                //System.out.println("name: " + name);
                //System.out.println("href: " + href);
                i++;
                if(i==10)break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            System.err.println("找不到景點符合("+where+")的資料。");
            System.exit(1);
        }
        //System.out.println(placeName);
        return placeName;
    }
    public Attractions crawlerPlaceData(String place,String keyword ){
        String url = "https://guide.easytravel.com.tw/" + keyword;
        String telephone = "";
        String address = "";
        String openTime = "";
        String ticket = "";
        Attractions attractions = null;
        try {
            Document doc = Jsoup.connect(url).get();

            //phone address opentime
            Elements lis = doc.select("#scenic .content li");

            // 迭代處理每個目標元素

            for (Element li : lis) {
                String text = li.text();
                //System.out.println(text);

                //解析資料並存起
                // 提取電話
                Pattern phonePattern = Pattern.compile("電　　話：([^\\n]+)");
                Matcher phoneMatcher = phonePattern.matcher(text);
                if (phoneMatcher.find()) {
                    telephone = phoneMatcher.group(1);
                }else{
                    telephone="無";
                }

                // 提取地址
                Pattern addressPattern = Pattern.compile("地　　址：([^\\n]+)");
                Matcher addressMatcher = addressPattern.matcher(text);
                if (addressMatcher.find()) {
                    address = addressMatcher.group(1);
                }else{
                    address="無";
                }

                // 提取營業時間
                Pattern openingHoursPattern = Pattern.compile("營業時間：([^\\n]+)");
                Matcher openingHoursMatcher = openingHoursPattern.matcher(text);
                if (openingHoursMatcher.find()) {
                    openTime = openingHoursMatcher.group(1);
                }else{
                    openTime="無";
                }
            }

            //ticket
            ticket="";
            Element table = doc.selectFirst("table.ticket");
            if (table != null) {
                // 提取表格数据
                Elements rowElements = table.select("tr");
                for (int i = 1; i < rowElements.size(); i++) {
                    Element rowElement = rowElements.get(i);
                    Elements cellElements = rowElement.select("td");
                    for (Element cellElement : cellElements) {
                        ticket+=cellElement.text() + "\t";
                    }
                    ticket+="\n";
                }
            }else{
                ticket="無";
            }


            //output
            attractions = new EasyTravelAttractionsItinerary(place,address,telephone,openTime,ticket);
            System.out.println("\n"+place);
            System.out.println("電話：" + telephone);
            System.out.println("地址：" + address);
            System.out.println("營業時間：" + openTime);
            System.out.println("門票："+ticket);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return attractions;
    }
}
