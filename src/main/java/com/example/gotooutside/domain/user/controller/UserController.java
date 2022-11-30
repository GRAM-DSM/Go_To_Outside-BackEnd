package com.example.gotooutside.domain.user.controller;

import com.example.gotooutside.domain.user.controller.dto.request.StudentSignUpRequest;
import com.example.gotooutside.domain.user.controller.dto.request.TeacherSignUpRequest;
import com.example.gotooutside.domain.user.service.StudentSignUpService;
import com.example.gotooutside.domain.user.service.TeacherSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final StudentSignUpService studentSignUpService;
    private final TeacherSignUpService teacherSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/student/signup")
    public void studentSignUp(StudentSignUpRequest request) {
        studentSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/teacher/signup")
    public void teacherSigUp(TeacherSignUpRequest request) {
        teacherSignUpService.execute(request);
    }
}
