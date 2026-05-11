package com.aichatservice.service;

import com.aichatservice.dto.ChatRequestDto;
import com.aichatservice.dto.ChatResponseDto;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    public ChatResponseDto chat(ChatRequestDto request) {

        String responseText;

        switch (request.getPersonality()) {
            case "coder":
                responseText = "I am a coding assistant. You said: " + request.getMessage();
                break;
            case "pirate":
                responseText = "Arrr! " + request.getMessage();
                break;
            default:
                responseText = "You said: " + request.getMessage();
        }

        ChatResponseDto response = new ChatResponseDto();
        response.setResponse(responseText);
        response.setSessionId(request.getSessionId());

        return response;
    }
}