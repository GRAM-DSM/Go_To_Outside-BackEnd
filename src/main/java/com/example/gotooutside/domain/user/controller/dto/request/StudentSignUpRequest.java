package com.example.gotooutside.domain.user.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentSignUpRequest {

    @NotBlank(message = "account_id 공백, null 포함 불가")
    @Size(min = 8, max = 10, message = "account_id는 8~10자 사이")
    private String accountId;

    @NotBlank(message = "password는 공백 null 포함 불가")
    @Size(min = 8, max = 20, message = "password는 8~20자 사이")
    private String password;

    @NotBlank(message = "number는 공백 null 포함 불가")
    @Size(min = 4, max = 4, message = "학번은 4자 고정")
    private String number;

    @NotBlank(message = "name는 공백 null 포함 불가")
    @Size(min = 2, max = 7, message = "이름은 2~7자")
    private String name;
}
