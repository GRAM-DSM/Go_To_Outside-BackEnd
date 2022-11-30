package com.example.gotooutside.domain.user.domain;

import com.example.gotooutside.global.enums.Authority;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Column(length = 4, nullable = false, unique = true)
    private String number;

    @Column(length = 7, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public User(String accountId, String password, String number, String name, Authority authority) {
        this.accountId = accountId;
        this.password = password;
        this.number = number;
        this.name = name;
        this.authority = authority;
    }
}
