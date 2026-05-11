package com.aichatservice.service;

import com.aichatservice.dto.ChatRequestDto;
import com.aichatservice.dto.ChatResponseDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatServiceTest {

    private final ChatService chatService = new ChatService();

    @Test
    void testCoderPersonality() {

        ChatRequestDto request = new ChatRequestDto();
        request.setPersonality("coder");
        request.setMessage("Hej");
        request.setSessionId("1");

        ChatResponseDto response = chatService.chat(request);

        assertNotNull(response);
        assertEquals("1", response.getSessionId());
    }
}