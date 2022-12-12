package com.example.gotooutside.domain.pass.domain.repository;

import com.example.gotooutside.domain.pass.domain.Pass;
import com.example.gotooutside.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PassRepository extends JpaRepository<Pass, Long> {

    List<Pass> findAllByOrderByCreatedAtDesc();
    Optional<Pass> findByUser(User user);
    boolean existsByUser(User user);
}
