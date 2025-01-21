package com.example.englevelup.dto.external;

import com.example.englevelup.model.gptapi.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ChatRequest {
    private String model;
    private List<Message> messages;

    @JsonProperty("max_tokens")
    private int maxTokens;

    public ChatRequest(String model, String prompt, String initialText, String requestMessage) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt + " " + initialText + requestMessage));
        this.maxTokens = 200;
    }
}
