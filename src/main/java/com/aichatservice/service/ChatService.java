package com.aichatservice.service;

import com.aichatservice.dto.ChatRequestDto;
import com.aichatservice.dto.ChatResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    private final RestClient restClient = RestClient.create();
    private final Map<String, List<String>> memory = new HashMap<>();

    public ChatResponseDto chat(ChatRequestDto request) {

        String systemPrompt = "You are a helpful assistant.";
        String sessionId = request.getSessionId();

        memory.putIfAbsent(sessionId, new ArrayList<>());
        memory.get(sessionId).add(request.getMessage());

        if ("coder".equals(request.getPersonality())) {
            systemPrompt = "You are a coding assistant.";
        } else if ("pirate".equals(request.getPersonality())) {
            systemPrompt = "You are a pirate. Speak like one.";
        }

        String responseText = restClient.post()
                .uri("https://httpbin.org/post")
                .body(Map.of(
                        "message", request.getMessage(),
                        "personality", systemPrompt
                ))
                .retrieve()
                .body(String.class);

        ChatResponseDto response = new ChatResponseDto();
        response.setResponse(responseText);
        response.setSessionId(request.getSessionId());

        return response;
    }
}