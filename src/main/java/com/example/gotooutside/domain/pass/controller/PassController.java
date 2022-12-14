package com.example.gotooutside.domain.pass.controller;

import com.example.gotooutside.domain.pass.controller.dto.request.CreatePassRequest;
import com.example.gotooutside.domain.pass.controller.dto.request.PermitPassRequest;
import com.example.gotooutside.domain.pass.controller.dto.response.PassDetailsResponse;
import com.example.gotooutside.domain.pass.controller.dto.response.PassListResponse;
import com.example.gotooutside.domain.pass.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/pass")
@RestController
public class PassController {

    private final CreatePassService createPassService;
    private final QueryPassListService queryPassListService;
    private final QueryPassDetailsService queryPassDetailsService;
    private final PermitPassService permitPassService;
    private final QueryMyPassService queryMyPassService;
    private final UnPermitPassService unPermitPassService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody @Valid CreatePassRequest request) {
        createPassService.execute(request);
    }

    @GetMapping("/list")
    public PassListResponse getList() {
        return queryPassListService.execute();
    }

    @GetMapping("/{pass-id}")
    public PassDetailsResponse getDetails(@PathVariable("pass-id") Long id) {
        return queryPassDetailsService.execute(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{pass-id}")
    public void permit(@PathVariable("pass-id") Long id, @RequestBody @Valid PermitPassRequest request) {
        permitPassService.execute(id, request);
    }

    @GetMapping
    public PassDetailsResponse getMyPass() {
        return queryMyPassService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{pass-id}")
    public void unPermit(@PathVariable("pass-id") Long passId) {
        unPermitPassService.execute(passId);
    }

}
