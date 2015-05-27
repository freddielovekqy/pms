package com.ntu.pms.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleDTO {

    private int id;
    private String name;
    private String description;
    private String place;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;
    private double time;
    private String type;
    private int projectId;
    private String projectName;
    private int creatorId;
    private String creatorName;
    private boolean isActive;

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

    public String getLongStartTimeStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(startTime);
    }

    public String getStartTimeStr() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd HH:mm");
        return format.format(startTime);
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Schedule [id=").append(id).append(", name=").append(name).append(", description=")
                .append(description).append(", startTime=").append(startTime).append(", time=").append(time)
                .append(", creator=").append(creatorName).append("]");
        return builder.toString();
    }
}
