package com.example.gotooutside.domain.user.domain.repository;

import com.example.gotooutside.domain.user.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    boolean existsByAccountId(String accountId);
}
