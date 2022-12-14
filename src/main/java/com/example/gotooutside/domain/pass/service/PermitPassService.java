package com.example.gotooutside.domain.pass.service;

import com.example.gotooutside.domain.pass.controller.dto.request.PermitPassRequest;
import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.pass.facade.PassFacade;
import com.example.gotooutside.domain.user.domain.Teacher;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.domain.user.facade.TeacherFacade;
import com.example.gotooutside.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PermitPassService {

    private final PassFacade passFacade;
    private final TeacherFacade teacherFacade;

    @Transactional
    public void execute(Long id, PermitPassRequest request) {
        Teacher teacher = teacherFacade.getCurrentTeacher();
        Pass pass = passFacade.getPassById(id);

        pass.permit(request.getIncomingTime(),teacher.getName() + "이(가) 허가함");
    }
}
