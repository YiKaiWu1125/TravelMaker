package ntou.cs.java2023.travelmaker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("start-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 576);
        stage.setTitle("Travel Maker");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        String imageUrl = getClass().getResource("/static/images/index.png").toExternalForm();
        scene.getRoot().setStyle("-fx-background-image: url('" + imageUrl + "'); -fx-background-repeat: no-repeat; -fx-background-size: cover;");
    }

    public static void main(String[] args) {
        launch();
    }
}