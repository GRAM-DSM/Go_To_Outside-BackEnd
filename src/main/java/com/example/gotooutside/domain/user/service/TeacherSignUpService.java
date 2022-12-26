package com.example.gotooutside.domain.user.service;

import com.example.gotooutside.domain.user.controller.dto.request.TeacherSignUpRequest;
import com.example.gotooutside.domain.user.domain.Teacher;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.domain.repository.TeacherRepository;
import com.example.gotooutside.domain.user.domain.repository.UserRepository;
import com.example.gotooutside.domain.user.exception.InvalidCodeException;
import com.example.gotooutside.domain.user.exception.UserAlreadyExistsException;
import com.example.gotooutside.global.enums.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class TeacherSignUpService {

    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${teacher.code}")
    private String code;

    @Transactional
    public void execute(TeacherSignUpRequest request) {

        if (teacherRepository.existsByAccountId(request.getAccountId())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        if (!code.equals(request.getCode())) {
            throw InvalidCodeException.EXCEPTION;
        }

        teacherRepository.save(Teacher.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .phoneNumber(request.getPhoneNumber())
                .group(request.getGroup())
                .grade(request.getGrade())
                .build());
    }
}
