package com.aichatservice.controller;

import com.aichatservice.dto.ChatRequestDto;
import com.aichatservice.dto.ChatResponseDto;
import com.aichatservice.service.ChatService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponseDto chat(@RequestBody ChatRequestDto request) {
        return chatService.chat(request);
    }
}