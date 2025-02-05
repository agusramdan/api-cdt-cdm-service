package com.agus.ramdan.cdm.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}