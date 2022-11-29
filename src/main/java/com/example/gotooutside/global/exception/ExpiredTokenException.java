package com.example.gotooutside.global.exception;

import com.example.gotooutside.global.error.exception.CustomException;
import com.example.gotooutside.global.error.exception.ErrorCode;

public class ExpiredTokenException extends CustomException {
    public static final CustomException EXCEPTION = new ExpiredTokenException();
    private ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
