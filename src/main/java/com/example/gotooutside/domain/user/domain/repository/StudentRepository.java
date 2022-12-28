package com.example.gotooutside.domain.user.domain.repository;

import com.example.gotooutside.domain.user.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByNumber(String number);
    Optional<Student> findByAccountId(String accountId);
}
