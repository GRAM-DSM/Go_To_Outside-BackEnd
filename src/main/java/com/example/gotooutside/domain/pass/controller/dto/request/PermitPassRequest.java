package com.example.gotooutside.domain.pass.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PermitPassRequest {

    @NotBlank(message = "들어오는 시간은 공백이나 널을 포함 할 수 없습니다.")
    @Size(min = 5, max = 5, message = "들어오는 시간은 5자입니다.")
    private String incomingTime;
}
