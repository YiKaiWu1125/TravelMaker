package org.example;

import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
public class ExportWord {
    public void run(){
        Scanner input = new Scanner(System.in);
        String title = "資料";
        System.out.print("input somethings : ");
        String content = input.nextLine();

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
        contentRun.setText(content);

        // 儲存Word檔案
        try (FileOutputStream out = new FileOutputStream("output.docx")) {
            document.write(out);
            System.out.println("Word檔案已匯出成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
