package com.example.gotooutside.domain.auth.service;

import com.example.gotooutside.domain.auth.controller.dto.request.LoginRequest;
import com.example.gotooutside.domain.auth.controller.dto.response.TokenResponse;
import com.example.gotooutside.domain.auth.exception.InvalidPasswordException;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.facade.UserFacade;
import com.example.gotooutside.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final UserFacade userFacade;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse execute(LoginRequest request) {

        User user = userFacade.getUserByAccountId(request.getAccountId());

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw InvalidPasswordException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(user.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAccountId());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .authority(user.getAuthority().toString())
                .build();
    }
}
