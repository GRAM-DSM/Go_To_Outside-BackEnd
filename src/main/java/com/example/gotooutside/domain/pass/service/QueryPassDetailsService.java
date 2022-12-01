package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.controller.dto.response.PassDetailsResponse;
import com.example.gotooutside.domain.pass.controller.dto.response.PassResponse;
import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.facade.PassFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryPassDetailsService {

    private final PassFacade passFacade;

    @Transactional(readOnly = true)
    public PassDetailsResponse execute(Long id) {

        Pass pass = passFacade.getPassById(id);

        return PassDetailsResponse.builder()
                .name(pass.getUser().getName())
                .number(pass.getUser().getNumber())
                .permitStatus(pass.isPermitStatus())
                .outingTime(pass.getOutingTime())
                .incomingTime(pass.getIncomingTime())
                .reason(pass.getReason())
                .permitter(pass.getPermitter())
                .build();
    }
}
