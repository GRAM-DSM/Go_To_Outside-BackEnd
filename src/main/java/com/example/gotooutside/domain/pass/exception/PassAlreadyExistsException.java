package com.example.gotooutside.domain.pass.exception;

import com.example.gotooutside.global.error.exception.CustomException;
import com.example.gotooutside.global.error.exception.ErrorCode;

public class PassAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION =
            new PassAlreadyExistsException();

    private PassAlreadyExistsException() {
        super(ErrorCode.PASS_ALREADY_EXISTS);
    }
}
