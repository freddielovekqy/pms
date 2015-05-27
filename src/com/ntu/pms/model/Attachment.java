package com.ntu.pms.model;

import java.util.Date;

public class Attachment extends BaseModel {

    private static final long serialVersionUID = -1617986412619854521L;

    private int id;
    private String name;
    private long size = 0;
    private int creatorId;
    private Date createTime;
    private int folderId;
    private boolean isActive = true;

    public Attachment(String name, long size, int creatorId, Date createTime, int folderId) {
        super();
        this.name = name;
        this.size = size;
        this.creatorId = creatorId;
        this.createTime = createTime;
        this.folderId = folderId;
    }

    public Attachment() {
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

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
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

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
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
        builder.append("Attachment [id=").append(id).append(", name=").append(name).append("creatorId=")
                .append(creatorId).append(", size=").append(size).append(", createTime=").append(createTime)
                .append(", folderId").append(folderId).append("]");
        return builder.toString();
    }

}
