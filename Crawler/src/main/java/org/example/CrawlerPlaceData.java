package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.*;

import java.io.IOException;

public class CrawlerPlaceData {
    private String four_Url;
    private String taiwan_Url;
    private String other_Url;

    //data先放這喔~~
    private String placeName;
    private String telephone;
    private String address;
    private String openTime;
    private String ticket;

    public void run(String place,String keyword ,String searchNet){
        placeName=place;
        if(searchNet.equals("完全台灣")){//die 我做不到提取門票時間QQ
            try {
                four_Url="https://okgo.tw/"+keyword;
                Document doc = Jsoup.connect(four_Url).get();

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
                System.out.println("\n"+place);
                System.out.println("電話：" + telephone);
                System.out.println("地址：" + address);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(searchNet.equals("四方旅遊")){
            try {
                taiwan_Url="https://guide.easytravel.com.tw/"+keyword;
                Document doc = Jsoup.connect(taiwan_Url).get();

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
                System.out.println("\n"+place);
                System.out.println("電話：" + telephone);
                System.out.println("地址：" + address);
                System.out.println("營業時間：" + openTime);
                System.out.println("門票："+ticket);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(searchNet.equals("台灣景點資訊")){
            //輔助
            other_Url="http://zip5.5432.tw/poi/?name="+keyword;

            try {

                Document doc = Jsoup.connect(other_Url).get();

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
                System.out.println("\n"+place);
                System.out.println("電話：" + telephone);
                System.out.println("地址：" + address);
                System.out.println("營業時間：" + openTime);
                System.out.println("門票：無");
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                System.err.println("找不到景點符合("+keyword+")的資料。");
                System.exit(1);
            }
        }
    }
}
