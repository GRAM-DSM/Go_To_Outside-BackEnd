package com.example.gotooutside.domain.auth.domain;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@Builder
@RedisHash
public class RefreshToken {

    @Id
    private String accountId;

    private String token;

    @TimeToLive
    private Long ttl;
}
