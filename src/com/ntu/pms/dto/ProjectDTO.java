package com.ntu.pms.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.oval.constraint.NotEmpty;

import com.ntu.pms.constant.OtherConstants;

public class ProjectDTO {

    private int id;
    @NotEmpty(message = "项目名不能为空")
    private String name;
    private String description;
    private Date createTime;
    private int creatorId;
    private String creatorName;
    private String creatorImage;
    private String creatorEmail;
    private int state = 1;
    private int isPublic;
    private String addMemberUrl;
    private int sprintId;
    private String sprintName;

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

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateTimeStr() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getCreatorImage() {
        return creatorImage;
    }

    public void setCreatorImage(String creatorImage) {
        this.creatorImage = creatorImage;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorEmail() {
        return creatorEmail;
    }

    public void setCreatorEmail(String creatorEmail) {
        this.creatorEmail = creatorEmail;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public String getAddMemberUrl() {
        return OtherConstants.BASE_PATH + OtherConstants.URL_ADD_PROJECT_MEMBER + addMemberUrl;
    }

    public void setAddMemberUrl(String addMemberUrl) {
        this.addMemberUrl = addMemberUrl;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ProjectDTO [id=").append(id).append(", name=").append(name).append(", description=")
                .append(description).append(", createTime=").append(createTime).append(", creatorId=")
                .append(creatorId).append(", creatorName=").append(creatorName).append(", state=").append(state)
                .append(", isPublic=").append(isPublic);

        return builder.toString();
    }

}
