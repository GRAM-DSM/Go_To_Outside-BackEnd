package com.example.gotooutside.global.scheduler;

import com.example.gotooutside.domain.pass.domain.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DeleteAllPassScheduler {

    private final PassRepository passRepository;

    @Scheduled(cron = "0 30 20 * * *")
    public void execute() {
        passRepository.deleteAll();
    }
}
