package com.example.gotooutside.global.security.jwt;

import com.example.gotooutside.domain.auth.domain.RefreshToken;
import com.example.gotooutside.domain.auth.domain.repository.RefreshTokenRepository;
import com.example.gotooutside.global.exception.ExpiredTokenException;
import com.example.gotooutside.global.exception.InvalidTokenException;
import com.example.gotooutside.global.security.auth.AuthDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;
    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(String id) {
        return generateToken(id, "access", jwtProperties.getAccessExp());
    }

    public String generateRefreshToken(String id) {
        String token = generateToken(id, "refresh", jwtProperties.getRefreshExp());
        refreshTokenRepository.save(RefreshToken.builder()
                .accountId(id)
                .token(token)
                .ttl(jwtProperties.getRefreshExp())
                .build());
        return token;
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = authDetailsService.loadUserByUsername(getSubject(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request) {
        String token = request.getHeader(jwtProperties.getHeader());
        if(token != null && token.startsWith(jwtProperties.getPrefix())) {
            return token.replace(jwtProperties.getPrefix(), "");
        }
        return null;
    }

    public LocalDateTime getExpiredAt() {
        return LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp());
    }

    private String generateToken(String id, String typ, Long exp) {
        return Jwts.builder()
                .setSubject(id)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .claim("typ", typ)
                .compact();
    }

    private String getSubject(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.getSecretKey())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw ExpiredTokenException.EXCEPTION;
        } catch (Exception e) {
            throw InvalidTokenException.EXCEPTION;
        }
    }
}
