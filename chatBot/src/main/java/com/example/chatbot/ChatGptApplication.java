package com.example.chatbot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class ChatGptApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatgpt-view.fxml"));
        BorderPane root = loader.load();

        // 获取从FXML文件中加载的控制器实例
        ChatgptController controller = loader.getController();

        // 其他代码

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Room");
        primaryStage.show();
        controller.getInputField().requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}