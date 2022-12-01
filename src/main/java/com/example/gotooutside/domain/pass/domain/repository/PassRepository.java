package com.example.gotooutside.domain.pass.domain.repository;

import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassRepository extends JpaRepository<Pass, Long> {

    List<Pass> findAllByOrderByCreatedAtDesc();
    boolean existsByUser(User user);
}
