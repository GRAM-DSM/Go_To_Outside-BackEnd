package com.example.gotooutside.domain.pass.controller;

import com.example.gotooutside.domain.pass.controller.dto.request.CreatePassRequest;
import com.example.gotooutside.domain.pass.controller.dto.request.PermitPassRequest;
import com.example.gotooutside.domain.pass.controller.dto.response.PassDetailsResponse;
import com.example.gotooutside.domain.pass.controller.dto.response.PassListResponse;
import com.example.gotooutside.domain.pass.service.CreatePassService;
import com.example.gotooutside.domain.pass.service.PermitPassService;
import com.example.gotooutside.domain.pass.service.QueryPassDetailsService;
import com.example.gotooutside.domain.pass.service.QueryPassListService;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody @Valid CreatePassRequest request) {
        createPassService.execute(request);
    }

    @GetMapping
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
}
