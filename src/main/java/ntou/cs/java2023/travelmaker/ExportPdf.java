package ntou.cs.java2023.travelmaker;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import java.io.File;

import java.io.IOException;

public class ExportPdf {
    public void run(){
        //data
        //data
        String[] name = {
                "象山",
                "象山"
        };

        String[] address = {
                "110台北市信義區信義路五段150巷401弄31號",
                "110台北市信義區信義路五段150巷401弄31號"
        };
        String[] phone = {
                "022222222",
                "022222222"
        };
        String[] openingHours = {
                "24小時營業",
                "24小時營業"
        };
        String[] price = {
                "0",
                "0"
        };
        String[] confirmation = {
                "是",
                "是"
        };

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(new PDRectangle(PDRectangle.A4.getWidth(), 800)); // 調整高度為 800 或其他適當值

            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true);

            PDType0Font font = PDType0Font.load(document, new File("./lib/TaipeiSansTCBeta-Light.ttf"));

            contentStream.setFont(font, 12);
            contentStream.setLeading(14.5f); // 設定行高為 14.5f 或其他適當值

            contentStream.beginText();

            contentStream.setFont(font, 12);

            contentStream.newLineAtOffset(50, 700);

            //title
            PDDocumentInformation info = document.getDocumentInformation();
            info.setTitle("旅遊規劃行程表");
            contentStream.showText("旅遊規劃行程表");
            contentStream.newLine();
            contentStream.showText("");
            contentStream.newLine();
            contentStream.showText("");

            for (int i = 0; i < name.length; i++) {

                contentStream.showText( i+1 +" :");
                contentStream.newLine();
                contentStream.showText("位址 :" + name[i]);
                contentStream.newLine();
                contentStream.showText("地址：" + address[i]);
                contentStream.newLine();
                contentStream.showText("電話：" + phone[i]);
                contentStream.newLine();
                contentStream.showText("營業時間：" + openingHours[i]);
                contentStream.newLine();
                contentStream.showText("價位：" + price[i]);
                contentStream.newLine();
                contentStream.showText("是否確認行程（含購票）：" + confirmation[i]);
                contentStream.newLine();
                contentStream.showText("");
                contentStream.newLine();
                contentStream.showText("");
            }
            contentStream.endText();

            contentStream.close();

            document.save("output.pdf");
            System.out.println("PDF檔案已匯出成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}