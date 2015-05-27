package com.ntu.pms.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RevisionDTO {

    private int id;
    private String description;
    private int objectId;
    private String objectName;
    private String type;
    private int projectId;
    private int creatorId;
    private String creatorName;
    private String creatorImage;
    private boolean isActive;

    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorImage() {
        return creatorImage;
    }

    public void setCreatorImage(String creatorImage) {
        this.creatorImage = creatorImage;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateDayTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(createTime);
    }

    public String getCreateDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);
        String date = calendar.get(Calendar.MONTH) + "ÔÂ" + calendar.get(Calendar.DAY_OF_MONTH) + "ÈÕ";
        return date;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RevisionDTO [id=").append(id).append(", description=").append(description)
                .append(", objectId=").append(objectId).append(", type=").append(type).append(", creatorId=")
                .append(creatorId).append(", creatorName=").append(creatorName).append(", isActive=").append(isActive)
                .append(", createTime=").append(createTime).append("]");
        return builder.toString();
    }
}
