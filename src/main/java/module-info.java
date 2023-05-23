module ntou.cs.java2023.travelmaker {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ntou.cs.java2023.travelmaker to javafx.fxml;
    exports ntou.cs.java2023.travelmaker;
}