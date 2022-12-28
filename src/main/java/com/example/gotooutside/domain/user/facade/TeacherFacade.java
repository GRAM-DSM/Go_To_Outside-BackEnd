package com.example.gotooutside.domain.user.facade;

import com.example.gotooutside.domain.user.domain.Teacher;
import com.example.gotooutside.domain.user.domain.repository.TeacherRepository;
import com.example.gotooutside.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeacherFacade {

    private final TeacherRepository teacherRepository;

    public Teacher getCurrentTeacher() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return teacherRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
