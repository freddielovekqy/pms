package com.ntu.pms.model;

public class User {

    private int id;
    private String name;
    private String password;
    private String jobNumber;
    private String email;
    private String image = "http://localhost:8080/PMS/data/user_111_20150426.png";
    private boolean isActive = true;

    public User() {

    }

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.password = builder.password;
        this.jobNumber = builder.jobNumber;
        this.email = builder.email;
        this.image = builder.image;
        this.isActive = builder.isActive;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    // Builder 模式(方便更快捷的创建一个对象)
    public static class Builder {
        private int id = 0;
        private String name = "";
        private String password = "";
        private String jobNumber = "";
        private String email = "";
        private String image = "";
        private boolean isActive = true;

        public Builder(int id) {
            this.id = id;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder jobNumber(String jobNumber) {
            this.jobNumber = jobNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder image(String image) {
            this.image = image;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=").append(id).append(", name=").append(name).append(", jobNumber=").append(jobNumber)
                .append(", email=").append(email).append(", image=").append(image).append(", isActive=")
                .append(isActive).append("]");
        return builder.toString();

    }

}