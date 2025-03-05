package com.dontwait.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//This place for we customize Exception body we need to notify for FE, is - a code, message and body JSON
//Muo^.n gio' be? ma*ng
public class AppException extends RuntimeException {

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
