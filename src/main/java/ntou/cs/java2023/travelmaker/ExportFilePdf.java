package ntou.cs.java2023.travelmaker;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ExportFilePdf extends ExportFile{
    @Override
    public void run(ArrayList<Attractions> attractionsList){

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
            int i = 0;
            for (Attractions attractions : attractionsList) {

                contentStream.showText( (++i) +" :");
                contentStream.newLine();
                contentStream.showText("景點名稱 :" + attractions.getAttractions());
                contentStream.newLine();
                contentStream.showText("地址：" + attractions.getAddress());
                contentStream.newLine();
                contentStream.showText("電話：" + attractions.getPhone());
                contentStream.newLine();
                contentStream.showText("營業時間：" + attractions.getBusinessTime());
                contentStream.newLine();
                try {
                    contentStream.showText("價位：" + attractions.getPrice());
                    contentStream.newLine();
                }catch (Exception e){System.out.println(e);}
                contentStream.showText("是否確認行程（含購票）：" + attractions.getIsBooking());
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
