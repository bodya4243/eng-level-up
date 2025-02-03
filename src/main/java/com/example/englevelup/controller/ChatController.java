package com.example.englevelup.controller;

import com.example.englevelup.dto.external.ChatRequest;
import com.example.englevelup.dto.external.ChatResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:application.properties")
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate template;

    @Operation(
            summary = "Get ChatGPT response",
            description = "Provide recommendations for grammar improvement in 5 sentences or fewer",
            parameters = {
                    @Parameter(
                            name = "prompt",
                            description = "Main input for ChatGPT",
                            required = true),
                    @Parameter(
                            name = "initialText",
                            description = "Optional initial text context"),
                    @Parameter(
                            name = "requestMessage",
                            description = "Additional message for context")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful response",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = String.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "500", description = "Server error")
            }
    )
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
