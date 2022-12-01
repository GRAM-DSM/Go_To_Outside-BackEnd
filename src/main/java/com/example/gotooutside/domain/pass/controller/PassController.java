package com.example.gotooutside.domain.pass.controller;

import com.example.gotooutside.domain.pass.controller.dto.request.CreatePassRequest;
import com.example.gotooutside.domain.pass.service.CreatePassService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/pass")
@RestController
public class PassController {

    private final CreatePassService createPassService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody @Valid CreatePassRequest request) {
        createPassService.execute(request);
    }
}
