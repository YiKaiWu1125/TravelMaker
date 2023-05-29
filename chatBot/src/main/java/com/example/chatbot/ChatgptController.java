package com.example.chatbot;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.input.KeyCode;


public class ChatgptController {
    @FXML
    private TextArea chatArea;

    @FXML
    private TextField inputField;

    @FXML
    private Button sendButton;

    private ChatGptApi chatApi;

    public void initialize() {
        String apiKey = "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";
        String model = "text-davinci-003";
        double temperature = 0.4;
        int maxTokens = 300;

        chatApi = new ChatGptApi(apiKey, model, temperature, maxTokens);
    }

    private void appendToChatArea(String message) {
        chatArea.appendText(message + "\n");
    }
}
