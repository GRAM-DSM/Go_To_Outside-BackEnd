package com.example.gotooutside.domain.auth.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "account_id 공백, null 포함 불가")
    @Size(min = 8, max = 10, message = "account_id는 8~10자 사이")
    private String accountId;

    @NotBlank(message = "password는 공백 null 포함 불가")
    @Size(min = 8, max = 20, message = "password는 8~20자 사이")
    private String password;

}
