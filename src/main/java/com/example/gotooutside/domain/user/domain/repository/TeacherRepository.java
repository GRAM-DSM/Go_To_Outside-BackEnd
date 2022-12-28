package com.example.gotooutside.domain.user.domain.repository;

import com.example.gotooutside.domain.user.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    boolean existsByAccountId(String accountId);
    Optional<Teacher> findByAccountId(String accountId);
}
