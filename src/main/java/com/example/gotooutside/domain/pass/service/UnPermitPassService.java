package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.facade.PassFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UnPermitPassService {

    private final PassFacade passFacade;

    @Transactional
    public void execute(Long id) {
        Pass pass = passFacade.getPassById(id);
        pass.unPermit();
    }
}
