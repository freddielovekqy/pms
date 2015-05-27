package com.ntu.pms.model;

public class ProjectUser extends BaseModel {

    private static final long serialVersionUID = 2073544962342345400L;

    private int id;
    private int projectId;
    private int userId;
    private boolean isManager = false;
    private boolean isActive = true;

    public ProjectUser() {

    }

    public ProjectUser(int projectId, int userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
