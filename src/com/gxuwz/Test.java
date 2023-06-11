package com.gxuwz;

import com.gxuwz.Frame.LoginFrame;
import com.gxuwz.entity.Department;
import com.gxuwz.entity.Doctor;
import com.gxuwz.entity.Role;
import com.gxuwz.entity.User;
import com.gxuwz.util.Data;

public class Test {
    public static void main(String[] args) {
        //初始化数据
        User[] users =
                {new User(1,"20220001","001","系统管理员",Data.getDate(),Data.getDate()),
                new User(2,"20220002","002","医生",Data.getDate(),Data.getDate()),
                new User(3,"20220003","003","医生",Data.getDate(),Data.getDate()),
                new User(4,"20220004","004","医生",Data.getDate(),Data.getDate()),};
        Role[] roles =
                {new Role(1,"系统管理员",Data.getDate(),Data.getDate(),"管理系统的角色"),
                new Role(2,"医生",Data.getDate(),Data.getDate(),"系统医生角色")};
        Doctor[] doctors =
                {new Doctor(1,"张三","20220002","男","皮肤科",1008611,"xxx大学","科室主任"),
                new Doctor(2,"李四","20220003","女","外科",1008612,"xxx学院","实习医生"),
                new Doctor(3,"王五","20220004","女","骨科",1008613,"xxx学院","住院医师")};
        Department[] departments =
                {new Department(1,"骨科"),
                 new Department(2,"皮肤科"),
                 new Department(3,"外科")
                };
        Data data = new Data(users,roles,doctors,departments);
        LoginFrame loginFrame = new LoginFrame(data);
    }
}
