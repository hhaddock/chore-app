package com.atlas.menter.dto;

import java.io.Serializable;

public class JwtResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String token;

    public JwtResponseDto(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
}
