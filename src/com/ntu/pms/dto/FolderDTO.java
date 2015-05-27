package com.ntu.pms.dto;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class FolderDTO {

    private int id;
    private String name;
    private int projectId;
    private String projectName;
    private int creatorId;
    private String creatorName;
    private Date createTime;
    private Date updateTime;
    private boolean isActive;
    private double fileSize;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getCreateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(createTime);
        StringBuilder builder = new StringBuilder();
        builder.append((calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
        return builder.toString();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(updateTime);
        StringBuilder builder = new StringBuilder();
        builder.append((calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日");
        return builder.toString();
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

    public String getFileSize() {
        DecimalFormat df = new DecimalFormat(".##");
        StringBuilder builder = new StringBuilder();
        if (fileSize < 1000) {
            builder.append(fileSize).append(" B");
        } else if (fileSize / 1024 < 1000) {
            builder.append(df.format(fileSize / 1024)).append(" KB");
        } else {
            builder.append(df.format(fileSize / 1024 / 1024)).append(" MB");
        }
        return builder.toString();
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Attachment [id=").append(id).append(", name=").append(name).append(", projectId=")
                .append(projectId).append(", projectName=").append(projectName).append(", creatorId=")
                .append(creatorId).append(", creatorName=").append(creatorName).append(", createrTime=")
                .append(createTime).append(", updateTime=").append(updateTime).append("]");
        return builder.toString();
    }

}
