package com.example.gotooutside.domain.user.service;

import com.example.gotooutside.domain.user.controller.dto.request.StudentSignUpRequest;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.domain.repository.UserRepository;
import com.example.gotooutside.domain.user.exception.UserAlreadyExistsException;
import com.example.gotooutside.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StudentSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(StudentSignUpRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        userRepository.save(User.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .number(request.getNumber())
                .name(request.getName())
                .authority(Authority.STUDENT)
                .build());
    }
}
