package com.example.gotooutside.domain.pass.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PassListResponse {

    private final List<PassResponse> passList;
}
