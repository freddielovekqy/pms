package com.ntu.pms.model;

public class Sequence extends BaseModel {

    private static final long serialVersionUID = -7945219315257296156L;

    private int id;
    private String type;
    private int currentValue = 0;
    private int projectId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sequence [id=").append(id).append(", type=").append(type).append(", currentValue=")
                .append(currentValue).append(", projectId=").append(projectId).append("]");
        return builder.toString();
    }

}
