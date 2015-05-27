package com.ntu.pms.dto;

import java.util.Date;

public class TicketDTO {

    private int id;
    private int serialNumber;
    private String name;
    private String type;
    private String description;
    private int ownerId;
    private String ownerName;
    private int projectId;
    private String projectName;
    private int sprintId;
    private String sprintName;
    private boolean blocked;
    private String state;
    private double planEst;
    private double taskEst;
    private double todo;
    private int creatorId;
    private String creatorName;
    private Date createTime;
    private int defectContentId;
    private boolean isActive = true;
    private int taskCount;

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

    public String getSerialStr() {
        return type + serialNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
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

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getPlanEst() {
        return planEst;
    }

    public void setPlanEst(double planEst) {
        this.planEst = planEst;
    }

    public double getTaskEst() {
        return taskEst;
    }

    public void setTaskEst(double taskEst) {
        this.taskEst = taskEst;
    }

    public double getTodo() {
        return todo;
    }

    public void setTodo(double todo) {
        this.todo = todo;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDefectContentId() {
        return defectContentId;
    }

    public void setDefectContentId(int defectContentId) {
        this.defectContentId = defectContentId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

}
