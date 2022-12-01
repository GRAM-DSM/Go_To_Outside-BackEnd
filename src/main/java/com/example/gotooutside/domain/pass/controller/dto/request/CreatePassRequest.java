package com.example.gotooutside.domain.pass.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreatePassRequest {

    @NotBlank(message = "외출사유는 공백이나 널 포함 불가입니다.")
    @Size(min = 1, max = 300, message = "외출사유는 1~300자 사이입니다.")
    private String reason;

    @NotBlank(message = "나가는 시간는 공백이나 널 포함 불가입니다.")
    @Size(min = 5, max = 5, message = "나가는 시간는 5자입니다.")
    private String outingTime;
}
