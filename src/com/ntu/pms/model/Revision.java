package com.ntu.pms.model;

import java.util.Date;

public class Revision extends BaseModel {

    private static final long serialVersionUID = -3597385241490474794L;

    private int id;
    private String description;
    private int objectId;
    private String objectName;
    private String type;
    private int projectId;
    private int creatorId;
    private boolean isActive = true;
    private Date createTime = new Date();

    public Revision() {

    }

    public Revision(String description, int objectId, String objectName, String type, int projectId, int creatorId) {
        super();
        this.description = description;
        this.objectId = objectId;
        this.objectName = objectName;
        this.type = type;
        this.projectId = projectId;
        this.creatorId = creatorId;
    }

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

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Revision [id=").append(id).append(", description=").append(description).append(", objectId=")
                .append(objectId).append(", type=").append(type).append(", creatorId=").append(creatorId)
                .append(", isActive=").append(isActive).append(", createTime=").append(createTime).append("]");
        return builder.toString();
    }
}
