module com.example.chatbot {
    requires javafx.controls;
    requires javafx.fxml;

    requires gson;
    requires okhttp3;
            
                            
    opens com.example.chatbot to javafx.fxml;
    exports com.example.chatbot;
}