package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.controller.dto.request.CreatePassRequest;
import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.domain.repository.PassRepository;
import com.example.gotooutside.domain.pass.domain.types.PermitStatus;
import com.example.gotooutside.domain.pass.exception.PassAlreadyExistsException;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CreatePassService {

    private final PassRepository passRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreatePassRequest request) {

        User user = userFacade.getCurrentUser();

        if (passRepository.existsByUser(user)) {
            throw PassAlreadyExistsException.EXCEPTION;
        }

        passRepository.save(Pass.builder()
                .user(user)
                .reason(request.getReason())
                .outingTime(request.getOutingTime())
                .incomingTime("HH:MM")
                .permitStatus(PermitStatus.WAITING)
                .build());
    }
}
