package com.example.gotooutside.domain.pass.facade;

import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.domain.repository.PassRepository;
import com.example.gotooutside.domain.pass.exception.PassNotFoundException;
import com.example.gotooutside.domain.user.domain.Student;
import com.example.gotooutside.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PassFacade {

    private final PassRepository passRepository;

    public Pass getPassById(Long id) {
        return passRepository.findById(id)
                .orElseThrow(() -> PassNotFoundException.EXCEPTION);
    }

    public Pass getPassByStudent(Student student) {
        return passRepository.findByStudent(student)
                .orElseThrow(() -> PassNotFoundException.EXCEPTION);
    }
}
