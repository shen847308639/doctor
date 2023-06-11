package com.gxuwz.entity;

public class Doctor {
    private int id;
    private String name;
    private String jobId;
    private String gender;
    private String department;
    private int phoneNumber;
    private String graduateSchool;
    private String position;

    public Doctor() {
    }

    public Doctor(int id, String name, String jobId, String gender, String department, int phoneNumber, String graduateSchool, String position) {
        this.id = id;
        this.name = name;
        this.jobId = jobId;
        this.gender = gender;
        this.department = department;
        this.phoneNumber = phoneNumber;
        this.graduateSchool = graduateSchool;
        this.position = position;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jodId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jodId='" + jobId + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", graduateSchool='" + graduateSchool + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
