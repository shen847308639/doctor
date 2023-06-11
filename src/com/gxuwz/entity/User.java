package com.gxuwz.entity;

public class User {
    private int id;
    private String username_doctorJodId;
    private String password;
    private String role;
    private String createTime;
    private String lastModifiedTime;

    public User() {
    }

    public User(int id, String username_doctorJodId, String password, String role, String createTime, String lastModifiedTime) {
        this.id = id;
        this.username_doctorJodId = username_doctorJodId;
        this.password = password;
        this.role = role;
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username_doctorJodId;
    }

    public void setUsername(String username_doctorJodId) {
        this.username_doctorJodId = username_doctorJodId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username_doctorJodId='" + username_doctorJodId + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + role +
                ", createTime='" + createTime + '\'' +
                ", lastModifiedTime='" + lastModifiedTime + '\'' +
                '}';
    }
}
