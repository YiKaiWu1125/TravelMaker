package ntou.cs.java2023.travelmaker;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    }

    private void appendToChatArea(String message) {
        chatArea.appendText(message + "\n");
    }

    // 新增的方法用于返回输入文本框的引用
    public TextField getInputField() {
        return inputField;
    }
}
