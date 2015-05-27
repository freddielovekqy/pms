package com.ntu.pms.exception;

public class ValidationException extends ServerException {

    private static final long serialVersionUID = -5006129154045246098L;

    public ValidationException() {
        super();
    }

    public ValidationException(String messageString) {
        super(messageString);
    }
}
