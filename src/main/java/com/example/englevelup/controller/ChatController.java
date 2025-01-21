package com.example.englevelup.controller;

import com.example.englevelup.dto.external.ChatRequest;
import com.example.englevelup.dto.external.ChatResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Value("${openai.model}")
    private String model;

    @Value(("${openai.api.url}"))
    private String apiUrl;

    @Autowired
    private RestTemplate template;

    @GetMapping
    public String chat(
            @RequestParam String prompt,
            @RequestParam(required = false) String initialText,
            @RequestParam(required = false) String requestMessage
    ) {

        ChatRequest request = new ChatRequest(model, prompt, initialText, requestMessage);
        ChatResponse chatGptResponse = template.postForObject(apiUrl, request, ChatResponse.class);
        return Objects.requireNonNull(chatGptResponse)
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }
}
