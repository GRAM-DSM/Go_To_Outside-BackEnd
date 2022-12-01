package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.controller.dto.response.PassListResponse;
import com.example.gotooutside.domain.pass.controller.dto.response.PassResponse;
import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.domain.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryPassListService {

    private final PassRepository passRepository;

    @Transactional(readOnly = true)
    public PassListResponse execute() {

        List<PassResponse> passList = passRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PassResponse::of)
                .toList();

        return new PassListResponse(passList);
    }
}
