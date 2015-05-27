package com.ntu.pms.model;

import java.util.Date;

public class Schedule extends BaseModel {

    private static final long serialVersionUID = 1769711837521366940L;

    private int id;
    private String name;
    private String description;
    private String place;
    private Date startTime;
    private double time;
    private String type;
    private int projectId;
    private int creatorId;
    private boolean isActive = true;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Schedule [id=").append(id).append(", name=").append(name).append(", description=")
                .append(description).append(", startTime=").append(startTime).append(", time=").append(time)
                .append(", creator=").append(creatorId).append("]");
        return builder.toString();
    }
}
