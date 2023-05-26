package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;
import java.io.IOException;
import java.lang.NullPointerException;

import java.util.ArrayList;

public class Crawler {
    private String four_Url;
    private String taiwan_Url;

    private String keyword;
    //save place name
    private ArrayList<String> placeName =new ArrayList<String>();
    //save place link
    private ArrayList<String> placeLink =new ArrayList<String>();
    public void run() {

        Scanner input =new Scanner(System.in);
        System.out.println("去哪:");
        keyword =input.nextLine();

        // 四方
        four_Url = "https://guide.easytravel.com.tw/search/?&s_key="+keyword;
        //完全台灣
        taiwan_Url = "https://okgo.tw/Search.html?kw="+keyword+"&st=1";



        //select search net
        System.out.println("四方旅遊/完全台灣/台灣景點資訊");
        String searchNet =input.nextLine();

        if(searchNet.equals("完全台灣")){
            try {

                Document doc = Jsoup.connect(taiwan_Url).get();

                Elements divs = doc.select("div.sItem1");

                // 前十地點，name
                int i=0;
                for (Element div:divs) {

                    Element link = div.selectFirst("a.STopic");
                    String name = link.attr("title");
                    placeName.add(name);
                    String href = link.attr("href");
                    placeLink.add(href);

                    System.out.println("name: " + name);
                    //System.out.println("href: " + href);
                    i++;
                    if(i==10)break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                System.err.println("找不到景點符合("+keyword+")的資料。");
                System.exit(1);
            }
        }else if(searchNet.equals("四方旅遊")){
            try {

                Document doc = Jsoup.connect(four_Url).get();

                Elements divs = doc.select("div.name");

                // 前十地點，name
                int i=0;
                for (Element div:divs) {

                    Element link = div.selectFirst("a");
                    String name = div.text();
                    placeName.add(name);
                    String href = link.attr("href");
                    placeLink.add(href);

                    System.out.println("name: " + name);
                    //System.out.println("href: " + href);
                    i++;
                    if(i==10)break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e){
                System.err.println("找不到景點符合("+keyword+")的資料。");
                System.exit(1);
            }
        }else if(searchNet.equals("台灣景點資訊")){
            CrawlerPlaceData crawlerPlaceData = new CrawlerPlaceData();
            crawlerPlaceData.run(keyword,keyword, searchNet);
        }
        if(!searchNet.equals("台灣景點資訊")) {
            //單一景點資料
            System.out.println("去哪part2:");
            //剛剛前十的資料
            String place = input.nextLine();

            int i = 0;
            String net = "";
            int console = 0;
            for (String name : placeName) {
                if (name.equals(place)) {
                    net = placeLink.get(i);
                    System.out.println("get");
                    console = 1;
                }
                i++;
            }
            if (console == 1) {

                CrawlerPlaceData crawlerPlaceData = new CrawlerPlaceData();
                crawlerPlaceData.run(place, net, searchNet);
            } else {
                System.out.println("fail");
            }
        }
    }
}