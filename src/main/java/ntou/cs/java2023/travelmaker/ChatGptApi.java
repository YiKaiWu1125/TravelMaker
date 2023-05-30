package ntou.cs.java2023.travelmaker;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class ChatGptApi {
    private final OkHttpClient client;
    private final String apiKey;
    private final String model;
    private final double temperature;
    private final int maxTokens;

    public ChatGptApi(String apiKey, String model, double temperature, int maxTokens) {
        this.client = new OkHttpClient();
        this.apiKey = apiKey;
        this.model = model;
        this.temperature = temperature;
        this.maxTokens = maxTokens;
    }

    public String getReply(String prompt) {
        MediaType mediaType = MediaType.parse("application/json");
        String jsonBody = "{\"model\": \"" + model + "\", \"prompt\": \"" + prompt + "\", \"temperature\": " + temperature + ", \"max_tokens\": " + maxTokens + "}";
        RequestBody body = RequestBody.create(mediaType, jsonBody);

        Request request = new Request.Builder()
                .url("https://api.openai.com/v1/completions")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = jsonParser.parse(responseBody).getAsJsonObject();
                String choicesArray = jsonObject.getAsJsonArray("choices").get(0).getAsJsonObject().get("text").getAsString();
                choicesArray = choicesArray.trim();
                if (choicesArray.length() > 0) {
                    return choicesArray;
                } else {
                    return "No available reply.";
                }
            } else {
                return "Request failed: " + response.code() + " " + response.message();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred.";
        }
    }
}
