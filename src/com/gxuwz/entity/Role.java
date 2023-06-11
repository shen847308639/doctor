package com.gxuwz.entity;

public class Role {
    private int id; //1为系统管理员 2为医生
    private String name;
    private String createTime;
    private String lastModifiedTime;
    private String description;

    public Role() {
    }

    public Role(int id, String name, String createTime, String lastModifiedTime, String description) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.lastModifiedTime = lastModifiedTime;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                ", lastModifiedTime='" + lastModifiedTime + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
