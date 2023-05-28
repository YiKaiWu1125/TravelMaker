package ntou.cs.java2023.travelmaker;

import java.util.Scanner;

public class ExportData {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("choose type: ");
        String contentType = input.nextLine().toLowerCase();

        if(contentType.equals("word")){
            System.out.println("you choose word!");
            ExportWord exportWord = new ExportWord();
            exportWord.run();
        }else if(contentType.equals("excel")){
            System.out.println("you choose excel!");
            ExportExcel exportExcel = new ExportExcel();
            exportExcel.run();

        }else if(contentType.equals("pdf")){//dead
            System.out.println("you choose pdf!");
            ExportPdf exportPdf = new ExportPdf();
            exportPdf.run();
        }

    }
}
