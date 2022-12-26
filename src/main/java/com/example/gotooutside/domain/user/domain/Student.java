package com.example.gotooutside.domain.user.domain;

import com.example.gotooutside.global.enums.Authority;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Student extends User {

    @Column(nullable = false, length = 4, unique = true)
    private String number;

    @Column(nullable = false, length = 11)
    private String GuardianPhoneNumber;

    @Builder
    public Student(String accountId, String password, String name, String number, String phoneNumber, String guardianPhoneNumber) {
        super(accountId, password, name, phoneNumber, Authority.STUDENT);
        this.number = number;
        this.GuardianPhoneNumber = guardianPhoneNumber;
    }
}
