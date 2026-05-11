package com.aichatservice.controller;

import com.aichatservice.service.ChatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChatController.class)
class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ChatService chatService;

    @Test
    void testChatEndpoint() throws Exception {

        mockMvc.perform(post("/api/v1/chat")
                        .contentType("application/json")
                        .content("""
                {
                    "personality": "coder",
                    "message": "Hej",
                    "sessionId": "1"
                }
                """))
                .andExpect(status().isOk());
    }
}