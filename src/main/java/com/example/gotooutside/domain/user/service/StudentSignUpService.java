package com.example.gotooutside.domain.user.service;

import com.example.gotooutside.domain.user.controller.dto.request.StudentSignUpRequest;
import com.example.gotooutside.domain.user.domain.Student;
import com.example.gotooutside.domain.user.domain.repository.StudentRepository;
import com.example.gotooutside.domain.user.exception.UserAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class StudentSignUpService {

    private final StudentRepository studentRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void execute(StudentSignUpRequest request) {

        if (studentRepository.existsByNumber(request.getNumber())) {
            throw UserAlreadyExistsException.EXCEPTION;
        }

        studentRepository.save(Student.builder()
                .accountId(request.getAccountId())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .number(request.getNumber())
                .name(request.getName())
                .guardianPhoneNumber(request.getGuardianPhoneNumber())
                .build());
    }
}
