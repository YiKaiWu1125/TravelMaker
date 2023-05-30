module ntou.cs.java2023.travelmaker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires org.jsoup;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.pdfbox;
    requires gson;
    requires okhttp3;

    opens ntou.cs.java2023.travelmaker to javafx.fxml;
    exports ntou.cs.java2023.travelmaker;

}