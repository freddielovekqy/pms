package com.ntu.pms.exception;

import java.util.Map;

public class BussinessException extends ServerException {

    private static final long serialVersionUID = -7527932445511589078L;

    public BussinessException() {
        super();
    }

    public BussinessException(String messageString, Throwable cause) {
        super(messageString, cause);
    }

    public BussinessException(String messageString) {
        super(messageString);
    }

    public BussinessException(String messageString, Map<String, Object> logMap) {
        super(messageString, logMap);
    }
}
