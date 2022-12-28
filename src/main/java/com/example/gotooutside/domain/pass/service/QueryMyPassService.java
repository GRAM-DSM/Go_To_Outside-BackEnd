package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.controller.dto.response.PassDetailsResponse;
import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.facade.PassFacade;
import com.example.gotooutside.domain.user.domain.Student;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.facade.StudentFacade;
import com.example.gotooutside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyPassService {

    private final StudentFacade studentFacade;
    private final PassFacade passFacade;

    @Transactional(readOnly = true)
    public PassDetailsResponse execute() {

        Student student = studentFacade.getCurrentStudent();
        Pass pass = passFacade.getPassByUser(student);

        return PassDetailsResponse.builder()
                .number(pass.getStudent().getNumber())
                .name(pass.getStudent().getName())
                .reason(pass.getReason())
                .outingTime(pass.getOutingTime())
                .incomingTime(pass.getIncomingTime())
                .permitter(pass.getPermitter())
                .build();
    }
}
