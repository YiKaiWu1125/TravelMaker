package ntou.cs.java2023.travelmaker;

import javafx.util.Pair;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //建立一個 搜索器(SearchTopTen)
        SearchTopTen STT = new SearchTopTen();
        //設定 搜尋的地點
        STT.search("台中");
        //開始搜尋 並回傳結果 型態為 ArrayList<Attractions>
        ArrayList<Attractions> attractionsList = STT.getTopTen();

        //開始建立行程
        TravelItinerary travelItinerary = new TravelItinerary();
        //將剛剛搜尋到的 景點 透過addAttraction 加入至 旅遊行中
        for(Attractions attractions : attractionsList){
            travelItinerary.addAttraction(attractions);
        }
        //設定旅遊景點匯出個格式
        travelItinerary.setExportType(new ExportFilePdf());
        //進行匯出
        travelItinerary.runExport();

        //可多次進行匯出(或更改輸出格式)
        travelItinerary.setExportType(new ExportFileWord());
        travelItinerary.runExport();
    }
}