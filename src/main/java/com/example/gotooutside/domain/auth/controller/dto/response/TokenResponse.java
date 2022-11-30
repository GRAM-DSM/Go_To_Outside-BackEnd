package com.example.gotooutside.domain.auth.controller.dto.response;

import com.example.gotooutside.global.enums.Authority;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TokenResponse {

    private String accessToken;
    private String refreshToken;
    private String authority;
}
