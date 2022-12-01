package com.example.gotooutside.domain.pass.exception;

import com.example.gotooutside.global.error.exception.CustomException;
import com.example.gotooutside.global.error.exception.ErrorCode;

public class PassNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new PassNotFoundException();

    private PassNotFoundException() {
        super(ErrorCode.PASS_NOT_FOUND);
    }
}
