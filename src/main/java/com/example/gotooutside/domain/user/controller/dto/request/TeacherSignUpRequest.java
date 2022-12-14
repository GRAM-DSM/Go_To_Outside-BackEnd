package com.example.gotooutside.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class TeacherSignUpRequest {

    @NotBlank(message = "account_id 공백, null 포함 불가")
    @Size(min = 8, max = 10, message = "account_id는 8~10자 사이")
    private String accountId;

    @NotBlank(message = "password는 공백 null 포함 불가")
    @Size(min = 8, max = 20, message = "password는 8~20자 사이")
    private String password;

    @NotBlank(message = "phoneNumber는 널 공백 포함 불가")
    @Size(min = 10, max = 11, message = "전화번호는 10~11자")
    private String phoneNumber;

    @NotBlank(message = "학년는 공백 null 포함 불가")
    @Size(min = 1, max = 1, message = "학년은 1자")
    private String grade;

    @NotBlank(message = "반는 공백 null 포함 불가")
    @Size(min = 1, max = 1, message = "반은 1자")
    private String group;

    @NotBlank(message = "name는 공백 null 포함 불가")
    @Size(min = 2, max = 7, message = "이름은 2~7자")
    private String name;

    @NotBlank(message = "코드는 공백 null 포함 불가")
    @Size(min = 6, max = 6, message = "코드는 6자")
    private String code;
}
