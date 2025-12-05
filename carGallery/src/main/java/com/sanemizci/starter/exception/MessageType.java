package com.sanemizci.starter.exception;

import lombok.Getter;
import lombok.Setter;

@Getter

public enum MessageType {
    NO_RECORD_EXISTS("1004","No record found"),
    GENERAL_EXCEPTION("9999","General error occured"),
    TOKEN_EXPIRE("1005","Token is expired log in again"),
    USERNAME_NOT_FOUND("1006","Username not found"),
    USERNAME_OR_PASSWORD_IS_NOT_VALID("1007","Username or password is not valid"),
    REFRESH_TOKEN_NOT_FOUND("1008","Refresh token not found"),
    REFRESH_TOKEN_EXPIRED("1009","Refresh token expired");

    
    private String code;

    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
