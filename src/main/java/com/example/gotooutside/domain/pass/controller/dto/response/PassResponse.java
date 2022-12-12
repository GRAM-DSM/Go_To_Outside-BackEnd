package com.example.gotooutside.domain.pass.controller.dto.response;

import com.example.gotooutside.domain.pass.domain.Pass;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PassResponse {

    private Long passId;
    private String name;
    private String number;
    private String permitStatus;

    public static PassResponse of(Pass pass) {
        return PassResponse.builder()
                .passId(pass.getId())
                .name(pass.getUser().getName())
                .number(pass.getUser().getNumber())
                .permitStatus(pass.getPermitStatus().toString())
                .build();

    }
}
