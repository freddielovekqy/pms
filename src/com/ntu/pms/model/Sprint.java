package com.ntu.pms.model;

import java.util.Date;

public class Sprint extends BaseModel {

    private static final long serialVersionUID = 4645244022813359786L;

    private int id;
    private int serialNumber;
    private String name;
    private String description;
    private boolean isCurrent;
    private Date startDate;
    private Date endDate;
    private int projectId;
    private int state = 1;
    private int creatorId;

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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getcreatorId() {
        return creatorId;
    }

    public void setcreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

}
