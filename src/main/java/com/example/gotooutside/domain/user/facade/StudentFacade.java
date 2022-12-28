package com.example.gotooutside.domain.user.facade;

import com.example.gotooutside.domain.user.domain.Student;
import com.example.gotooutside.domain.user.domain.repository.StudentRepository;
import com.example.gotooutside.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StudentFacade {

    private final StudentRepository studentRepository;

    public Student getCurrentStudent() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return studentRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
