package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExportExcel {
    public void run(){

        //data
        String[] name = {
                "象山",
                "象山"
        };

        String[] addresses = {
                "110台北市信義區信義路五段150巷401弄31號",
                "110台北市信義區信義路五段150巷401弄31號"
        };
        String[] phones = {
                "022222222",
                "022222222"
        };
        String[] openingHours = {
                "24小時營業",
                "24小時營業"
        };
        String[] prices = {
                "0",
                "0"
        };
        String[] confirmation = {
                "是",
                "是"
        };


        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("資料");

            // 設置標題
            Row titleRow = sheet.createRow(0);
            CellStyle titleCellStyle = workbook.createCellStyle();
            Font titleFont = workbook.createFont();
            titleFont.setBold(true);
            titleCellStyle.setFont(titleFont);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("資料");
            titleCell.setCellStyle(titleCellStyle);

            // 設置行
            for (int i = 0; i < addresses.length; i++) {
                int rowIndex = i * 7 + 1;

                Row addressRow = sheet.createRow(rowIndex);
                addressRow.createCell(0).setCellValue("位址：");
                addressRow.createCell(1).setCellValue(name[i]);

                Row dataRow1 = sheet.createRow(rowIndex + 1);
                dataRow1.createCell(0).setCellValue("地址：");
                dataRow1.createCell(1).setCellValue(addresses[i]);

                Row dataRow2 = sheet.createRow(rowIndex + 2);
                dataRow2.createCell(0).setCellValue("電話：");
                dataRow2.createCell(1).setCellValue(phones[i]);

                Row dataRow3 = sheet.createRow(rowIndex + 3);
                dataRow3.createCell(0).setCellValue("營業時間：");
                dataRow3.createCell(1).setCellValue(openingHours[i]);

                Row dataRow4 = sheet.createRow(rowIndex + 4);
                dataRow4.createCell(0).setCellValue("價位：");
                dataRow4.createCell(1).setCellValue(prices[i]);

                Row dataRow5 = sheet.createRow(rowIndex + 5);
                dataRow5.createCell(0).setCellValue("是否確認行程（含購票）：");
                dataRow5.createCell(1).setCellValue(confirmation[i]);
            }

            // 自動調整列寬
            for (int i = 0; i < 2; i++) {
                sheet.autoSizeColumn(i);
            }

            // save
            try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
                workbook.write(fileOut);
                System.out.println("Excel檔案已匯出成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
