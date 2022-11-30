package com.example.gotooutside.domain.auth.domain.repository;

import com.example.gotooutside.domain.auth.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
