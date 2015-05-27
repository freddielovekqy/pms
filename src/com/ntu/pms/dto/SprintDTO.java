package com.ntu.pms.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SprintDTO {

    private int id;
    private int serialNumber;
    private String name;
    private String description;
    private boolean isCurrent;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;
    private int projectId;
    private String projectName;
    private int state = 1;
    private int creatorId;
    private String creatorName;
    private boolean isMove;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public boolean isMove() {
        return isMove;
    }

    public void setMove(boolean isMove) {
        this.isMove = isMove;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SprintDTO [id=").append(id).append(", name=").append(name).append(", serialNumber=")
                .append(serialNumber).append(", startDate=").append(startDate).append(", endDate=").append(endDate)
                .append(", projectName").append(projectName).append(", creatorName").append(creatorName).append("]");
        return builder.toString();
    }

}
