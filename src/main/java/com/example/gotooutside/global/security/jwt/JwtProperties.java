package com.example.gotooutside.global.security.jwt;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Base64;

@Getter
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

    private final String secretKey;
    private final String header;
    private final String prefix;
    private final Long accessExp;
    private final Long refreshExp;

    public JwtProperties(String secretKey, String header, String prefix
            , Long accessExp, Long refreshExp) {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.header = header;
        this.prefix = prefix;
        this.accessExp = accessExp*1000;
        this.refreshExp = refreshExp*1000;
    }
}
