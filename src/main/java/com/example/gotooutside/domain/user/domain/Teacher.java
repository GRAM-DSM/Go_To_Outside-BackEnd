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
public class Teacher extends User {

    @Column(length = 1, nullable = false)
    private String grade;
    @Column(length = 1, nullable = false)
    private String classNumber;

    @Builder
    public Teacher(String accountId, String password, String name, String phoneNumber, String grade, String classNumber) {
        super(accountId, password, name, phoneNumber, Authority.TEACHER);
        this.grade = grade;
        this.classNumber = classNumber;
    }
}
