package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.controller.dto.response.PassDetailsResponse;
import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.facade.PassFacade;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyPassService {

    private final UserFacade userFacade;
    private final PassFacade passFacade;

    @Transactional(readOnly = true)
    public PassDetailsResponse execute() {

        User user = userFacade.getCurrentUser();
        Pass pass = passFacade.getPassByUser(user);

        return PassDetailsResponse.builder()
                .number(pass.getUser().getNumber())
                .name(pass.getUser().getName())
                .reason(pass.getReason())
                .outingTime(pass.getOutingTime())
                .incomingTime(pass.getIncomingTime())
                .permitter(pass.getPermitter())
                .build();
    }
}
