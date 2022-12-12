package com.example.gotooutside.domain.pass.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PassDetailsResponse {

    private String name;
    private String number;
    private String permitStatus;
    private String reason;
    private String outingTime;
    private String incomingTime;
    private String permitter;

}
