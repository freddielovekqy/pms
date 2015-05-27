package com.ntu.pms.model;

import java.util.Date;

public class Project extends BaseModel {

    private static final long serialVersionUID = 9061719760917771575L;

    private int id;
    private String name;
    private String description;
    private Date createTime;
    private int creatorId;
    private int state = 1;
    private int isPublic;
    private String addMemberUrl;

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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
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
        return addMemberUrl;
    }

    public void setAddMemberUrl(String addMemberUrl) {
        this.addMemberUrl = addMemberUrl;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Project [id=").append(id).append(", name=").append(name).append(", description=")
                .append(description).append(", createTime=").append(createTime).append(", creatorId=")
                .append(creatorId).append(", state=").append(state).append(", isPublic=").append(isPublic);
        return builder.toString();
    }
}
