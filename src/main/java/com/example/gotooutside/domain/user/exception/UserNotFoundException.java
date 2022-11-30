package com.example.gotooutside.domain.user.exception;

import com.example.gotooutside.global.error.exception.CustomException;
import com.example.gotooutside.global.error.exception.ErrorCode;

public class UserNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
