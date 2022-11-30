package com.example.gotooutside.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_TOKEN(401,"Token Expired" ),
    INVALID_TOKEN(401,"Invalid Token"),
    INVALID_CODE(401, "Invalid Code"),
    INVALID_PASSWORD(401, "Invalid Password"),

    USER_NOT_FOUND(404, "User Not Found"),

    USER_ALREADY_EXISTS(409, "User Already Exists");

    private final Integer status;
    private final String message;
}
