package com.example.gotooutside.domain.user.domain;

import com.example.gotooutside.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@DiscriminatorColumn
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public abstract class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 10, nullable = false, unique = true)
    private String accountId;

    @Column(nullable = false)
    private String password;

    @Column(length = 7, nullable = false)
    private String name;

    @Column(nullable = false, length = 11, unique = true)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public User(String accountId, String password, String name, String phoneNumber, Authority authority) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.authority = authority;
    }
}
