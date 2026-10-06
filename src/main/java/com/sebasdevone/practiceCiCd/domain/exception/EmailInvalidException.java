package com.sebasdevone.practiceCiCd.domain.exception;

public class EmailInvalidException extends RuntimeException {
    public EmailInvalidException(String message) {
        super(message);
    }
}
