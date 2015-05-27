package com.ntu.pms.model;

import java.util.Date;

public class Folder extends BaseModel {

    private static final long serialVersionUID = -1617986412619854521L;

    private int id;
    private String name;
    private int projectId;
    private int creatorId;
    private Date createTime;
    private Date updateTime;
    private boolean isActive = true;
    private long fileSize = 0;

    public Folder(int projectId, int creatorId, Date createTime, Date updateTime) {
        super();
        this.projectId = projectId;
        this.creatorId = creatorId;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Folder() {
        super();
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Attachment [id=").append(id).append(", name=").append(name).append(", projectId=")
                .append(projectId).append(", creatorId=").append(creatorId).append(", createrTime=").append(createTime)
                .append(", updateTime=").append(updateTime).append("]");
        return builder.toString();
    }

}
