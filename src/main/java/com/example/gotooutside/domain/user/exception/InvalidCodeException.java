package com.example.gotooutside.domain.user.exception;

import com.example.gotooutside.global.error.exception.CustomException;
import com.example.gotooutside.global.error.exception.ErrorCode;

public class InvalidCodeException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidCodeException();

    private InvalidCodeException() {
        super(ErrorCode.INVALID_CODE);
    }
}
