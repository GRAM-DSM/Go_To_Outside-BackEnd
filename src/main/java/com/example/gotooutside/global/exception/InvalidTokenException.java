package com.example.gotooutside.global.exception;


import com.example.gotooutside.global.error.exception.CustomException;
import com.example.gotooutside.global.error.exception.ErrorCode;

public class InvalidTokenException extends CustomException {
    public static final CustomException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
