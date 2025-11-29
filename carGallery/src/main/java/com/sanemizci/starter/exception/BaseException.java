package com.sanemizci.starter.exception;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    public BaseException(ErrorMessage errorMessage) {
        super(errorMessage.prepareErrorMessage());
    }
}
