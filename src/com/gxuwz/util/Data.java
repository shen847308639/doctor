package com.gxuwz.util;

import com.gxuwz.entity.Department;
import com.gxuwz.entity.Doctor;
import com.gxuwz.entity.Role;
import com.gxuwz.entity.User;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    private User[] users;
    private Role[] roles;
    private Doctor[] doctors;
    private Department[] departments;

    public Data(User[] users, Role[] roles, Doctor[] doctors, Department[] departments) {
        this.users = users;
        this.roles = roles;
        this.doctors = doctors;
        this.departments = departments;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    public void setDoctors(Doctor[] doctors) {
        this.doctors = doctors;
    }

    public User[] getUsers() {
        return users;
    }

    public Role[] getRoles() {
        return roles;
    }

    public Doctor[] getDoctors() {
        return doctors;
    }

    public static String getDate(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(now);
        System.out.println("Formatted Date: " + formattedDate);
        return formattedDate;
    }

    public static void setDate(String format){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String formattedDate = sdf.format(now);
        System.out.println("Formatted Date: " + formattedDate);
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }
}
