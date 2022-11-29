package com.example.gotooutside.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_TOKEN(401,"Token Expired" ),
    INVALID_TOKEN(401,"Invalid Token"),

    USER_NOT_FOUND(404, "User Not Found");

    private final Integer status;
    private final String message;
}
