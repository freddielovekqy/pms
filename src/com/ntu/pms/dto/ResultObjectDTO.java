package com.ntu.pms.dto;

public class ResultObjectDTO {

    private Integer mesCount = 0;
    private Object resultObject;
    private String returnMessage;
    private int status;

    public Integer getMesCount() {
        return mesCount;
    }

    public void setMesCount(Integer mesCount) {
        this.mesCount = mesCount;
    }

    public Object getResultObject() {
        return resultObject;
    }

    public void setResultObject(Object resultObject) {
        this.resultObject = resultObject;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
