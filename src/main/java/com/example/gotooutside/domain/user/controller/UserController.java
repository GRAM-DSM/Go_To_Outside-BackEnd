package com.example.gotooutside.domain.user.controller;

import com.example.gotooutside.domain.user.controller.dto.request.StudentSignUpRequest;
import com.example.gotooutside.domain.user.controller.dto.request.TeacherSignUpRequest;
import com.example.gotooutside.domain.user.service.StudentSignUpService;
import com.example.gotooutside.domain.user.service.TeacherSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final StudentSignUpService studentSignUpService;
    private final TeacherSignUpService teacherSignUpService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/student/signup")
    public void studentSignUp(@RequestBody @Valid StudentSignUpRequest request) {
        studentSignUpService.execute(request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/teacher/signup")
    public void teacherSigUp(@RequestBody @Valid TeacherSignUpRequest request) {
        teacherSignUpService.execute(request);
    }
}
