package com.example.gotooutside.domain.auth.controller;

import com.example.gotooutside.domain.auth.controller.dto.request.LoginRequest;
import com.example.gotooutside.domain.auth.controller.dto.response.TokenResponse;
import com.example.gotooutside.domain.auth.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {

    private final LoginService loginService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.execute(request);
    }
}
