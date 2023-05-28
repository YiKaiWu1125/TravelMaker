package ntou.cs.java2023.travelmaker;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExportFileWord extends ExportFile{
    @Override
    public void run(ArrayList<Attractions> attractionsList){
        String title = "旅遊規劃行程表";

        // 創建新的Word文檔
        XWPFDocument document = new XWPFDocument();

        // 添加標題
        XWPFParagraph titleParagraph = document.createParagraph();
        XWPFRun titleRun = titleParagraph.createRun();
        titleRun.setText(title);
        titleRun.setBold(true);
        titleRun.setFontSize(16);

        // 添加內容
        XWPFParagraph contentParagraph = document.createParagraph();
        XWPFRun contentRun = contentParagraph.createRun();

        for(Attractions attractions : attractionsList){
            contentRun.setText(attractions.toString()+"\n");
        }

        // 儲存Word檔案
        try (FileOutputStream out = new FileOutputStream("output.docx")) {
            document.write(out);
            System.out.println("Word檔案已匯出成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
