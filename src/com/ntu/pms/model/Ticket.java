package com.ntu.pms.model;

import java.util.Date;

public class Ticket extends BaseModel {

    private static final long serialVersionUID = 8329589440904677125L;

    private int id;
    private int serialNumber;
    private String name;
    private String type;
    private String description;
    private int ownerId;
    private int projectId;
    private int sprintId;
    private boolean blocked;
    private String state;
    private double planEst;
    private double taskEst;
    private double todo;
    private int creatorId;
    private Date createTime;
    private boolean isActive = true;

    public Ticket() {
        super();
    }

    public Ticket(int serialNumber, String name, String type, int projectId, int sprintId, String state) {
        super();
        this.serialNumber = serialNumber;
        this.name = name;
        this.type = type;
        this.projectId = projectId;
        this.sprintId = sprintId;
        this.state = state;
    }

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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ticket [id=").append(id).append(", name=").append(name).append(", type=").append(type)
                .append(", ownerId=").append(ownerId).append(", sprintId=").append(sprintId).append(", blocked=")
                .append(blocked).append("]");
        return builder.toString();
    }

}
