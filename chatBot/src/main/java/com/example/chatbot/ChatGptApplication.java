package com.example.chatbot;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

public class ChatGptApplication extends Application {
    private ChatGptApi chatApi;

    @FXML
    private TextArea chatArea;
    @FXML
    private TextField inputField;
    @FXML
    private Button sendButton;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chatgpt-view.fxml"));
        loader.setController(this);
        BorderPane root = loader.load();

        chatArea = (TextArea) loader.getNamespace().get("chatArea");
        inputField = (TextField) loader.getNamespace().get("inputField");
        sendButton = (Button) loader.getNamespace().get("sendButton");


        String apiKey = "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";
        String model = "text-davinci-003";
        double temperature = 0.4;
        int maxTokens = 300;

        chatApi = new ChatGptApi(apiKey, model, temperature, maxTokens);

        sendButton.setOnAction(event -> {
            String message = inputField.getText();
            if (!message.isEmpty()) {
                appendToChatArea("你: " + message);
                String reply = chatApi.getReply(message);
                appendToChatArea("機器人: " + reply+"\n");
                inputField.clear();
            }
        });

        inputField.setOnAction(event -> {
            String message = inputField.getText();
            if (!message.isEmpty()) {
                appendToChatArea("你: " + message);
                String reply = chatApi.getReply(message);
                appendToChatArea("機器人: " + reply + "\n");
                inputField.clear();
            }
        });

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Chat Room");
        primaryStage.show();
        inputField.requestFocus();
    }

    private void appendToChatArea(String message) {
        chatArea.appendText(message + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}