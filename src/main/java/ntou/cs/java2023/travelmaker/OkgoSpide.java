package ntou.cs.java2023.travelmaker;
import javafx.util.Pair;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OkgoSpide extends Spide{//爬蟲
    //完全台灣
    @Override
    public ArrayList<Pair<String, String>> crawlerPlace(String where){
        ArrayList<Pair<String, String>> placeName = new ArrayList<Pair<String, String>>();
        String url = "https://okgo.tw/Search.html?kw=" + where + "&st=1";
        try {
            Document doc = Jsoup.connect(url).get();
            Elements divs = doc.select("div.sItem1");
            // 前十地點，name
            int i=0;
            for (Element div:divs) {
                Element link = div.selectFirst("a.STopic");
                String name = link.attr("title");
                String href = link.attr("href");
                placeName.add(new Pair<String, String>(name,href));
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
    @Override
    public Attractions crawlerPlaceData(String place,String keyword ){//die 我做不到提取門票時間QQ
        String url = "https://guide.easytravel.com.tw/" + keyword;
        String telephone = "";
        String address = "";
        String openTime = "";
        String ticket = "";
        Attractions attractions = null;
        try {
            url="https://okgo.tw/"+keyword;
            Document doc = Jsoup.connect(url).get();

            //phone address
            Elements divs = doc.select("div.sec3.word.Resize");
            System.out.println(divs);

            // 正则表达式匹配电话号码
            String phoneRegex = "\\d{2}-\\d{8}";
            Pattern phonePattern = Pattern.compile(phoneRegex);
            Matcher phoneMatcher = phonePattern.matcher(divs.toString());

            // 提取电话号码
            if (phoneMatcher.find()) {
                telephone = phoneMatcher.group();
            }else{
                telephone="無";
            }

            // 提取地址
            String addressRegex = "地址：(.+)";
            Pattern addressPattern = Pattern.compile(addressRegex);
            Matcher addressMatcher = addressPattern.matcher(divs.toString());

            if (addressMatcher.find()) {
                address = addressMatcher.group(1);
            }else{
                address="無";
            }
            //output
            attractions = new OkgoAttractionsItinerary(place,address,telephone,openTime,ticket);
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
