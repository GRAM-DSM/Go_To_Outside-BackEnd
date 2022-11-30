package com.example.gotooutside.domain.user.service;

import com.example.gotooutside.domain.user.controller.dto.request.TeacherSignUpRequest;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.domain.repository.UserRepository;
import com.example.gotooutside.domain.user.exception.InvalidCodeException;
import com.example.gotooutside.domain.user.exception.UserAlreadyExistsException;
import com.example.gotooutside.global.enums.Authority;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${teacher.code}")
    private String code;

    @Transactional
    public void execute(TeacherSignUpRequest request) {

        String classroom = request.getGrade() + request.getGroup() + "00";

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        if (userRepository.existsByNumber(classroom)) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        if (!code.equals(request.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .number(classroom)
                .name(request.getName())
                .authority(Authority.TEACHER)
                .build());
    }
}
