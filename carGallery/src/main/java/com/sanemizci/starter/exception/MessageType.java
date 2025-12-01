package com.sanemizci.starter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum MessageType {
    NO_RECORD_EXISTS("1004","No record found"),
    GENERAL_EXCEPTION("9999","General error occured"),
    TOKEN_EXPIRE("1005","Token is expired log in again");

    private String code;

    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
