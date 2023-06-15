package ru.rrenat358.core.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
