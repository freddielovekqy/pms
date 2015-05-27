package com.ntu.pms.dto;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class AttachmentDTO {

    private int id;
    private String name;
    private double size;
    private int creatorId;
    private String creatorName;
    private Date createTime;
    private int folderId;
    private String folderName;
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

    public String getSize() {
        DecimalFormat df = new DecimalFormat(".##");
        StringBuilder builder = new StringBuilder();
        if (size < 1000) {
            builder.append(size).append(" B");
        } else if (size / 1024 < 1000) {
            builder.append(df.format(size / 1024)).append(" KB");
        } else {
            builder.append(df.format(size / 1024 / 1024)).append(" MB");
        }
        return builder.toString();
    }

    public void setSize(double size) {
        this.size = size;
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
        builder.append((calendar.get(Calendar.MONTH) + 1) + "ÔÂ" + calendar.get(Calendar.DAY_OF_MONTH) + "ÈÕ");
        return builder.toString();
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

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

}
