package com.aichatservice.dto;

import lombok.Data;

@Data
public class ChatRequestDto {

    private String personality;
    private String message;
    private String sessionId;

}
