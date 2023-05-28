package ntou.cs.java2023.travelmaker;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExportFileExcel extends  ExportFile{
    @Override
    public void run(ArrayList<Attractions> attractionsList) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("資料");

            // 設置標題
            Row titleRow = sheet.createRow(0);
            CellStyle titleCellStyle = workbook.createCellStyle();
            Font titleFont = workbook.createFont();
            titleFont.setBold(true);
            titleCellStyle.setFont(titleFont);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("旅遊規劃行程表");
            titleCell.setCellStyle(titleCellStyle);

            // 設置行
            for (int i = 0; i < attractionsList.size(); i++) {
                int rowIndex = i * 7 + 1;

                Row addressRow = sheet.createRow(rowIndex);
                addressRow.createCell(0).setCellValue("位址：");
                addressRow.createCell(1).setCellValue(attractionsList.get(i).getAttraction());

                Row dataRow1 = sheet.createRow(rowIndex + 1);
                dataRow1.createCell(0).setCellValue("地址：");
                dataRow1.createCell(1).setCellValue(attractionsList.get(i).getAddress());

                Row dataRow2 = sheet.createRow(rowIndex + 2);
                dataRow2.createCell(0).setCellValue("電話：");
                dataRow2.createCell(1).setCellValue(attractionsList.get(i).getPhone());

                Row dataRow3 = sheet.createRow(rowIndex + 3);
                dataRow3.createCell(0).setCellValue("營業時間：");
                dataRow3.createCell(1).setCellValue(attractionsList.get(i).getBusinessTime());

                Row dataRow4 = sheet.createRow(rowIndex + 4);
                dataRow4.createCell(0).setCellValue("價位：");
                dataRow4.createCell(1).setCellValue(attractionsList.get(i).getPrice());

                Row dataRow5 = sheet.createRow(rowIndex + 5);
                dataRow5.createCell(0).setCellValue("是否確認行程（含購票）：");
                dataRow5.createCell(1).setCellValue(attractionsList.get(i).getIsBooking());
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
