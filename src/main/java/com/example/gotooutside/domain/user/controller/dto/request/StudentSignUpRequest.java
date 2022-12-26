package com.example.gotooutside.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @NotBlank(message = "phoneNumber는 널 공백 포함 불가")
    @Size(min = 10, max = 11, message = "전화번호는 10~11자")
    private String phoneNumber;

    @NotBlank(message = "name는 공백 null 포함 불가")
    @Size(min = 2, max = 7, message = "이름은 2~7자")
    private String name;

    @NotBlank(message = "guardianPhoneNumber는 널 공백 포함 불가")
    @Size(min = 10, max = 11, message = "보호자 전화번호는 10~11자")
    private String guardianPhoneNumber;
}
