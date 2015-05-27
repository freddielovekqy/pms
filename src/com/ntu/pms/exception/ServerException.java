package com.ntu.pms.exception;

import java.util.Map;

public class ServerException extends Exception {

    private static final long serialVersionUID = -1737543803131431143L;
    private Map<String, Object> exceptionMap;

    public ServerException() {
        super();
    }

    public ServerException(String messageString, Throwable cause) {
        super(messageString, cause);
    }

    public ServerException(String messageString) {
        super(messageString);
    }

    public ServerException(String messageString, Map<String, Object> logMap) {
        super(messageString);
        logMap.put("exceptionMessage", super.getMessage());
        logMap.put("exception", super.getCause());
        exceptionMap = logMap;
    }

    public Map<String, Object> getExceptionMap() {
        return exceptionMap;
    }

    public void setExceptionMap(Map<String, Object> exceptionMap) {
        this.exceptionMap = exceptionMap;
    }

}
