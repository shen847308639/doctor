package com.gxuwz.Frame;

import com.gxuwz.entity.Doctor;
import com.gxuwz.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DoctorFrame extends JFrame implements ActionListener {
    private JTextField jobField, nameField, departmentField, phoneField, schoolField, positionField, passwordTextField;
    private JButton viewButton, updateButton;
    private JLabel jobLabel, nameLabel, departmentLabel, phoneLabel, schoolLabel, positionLabel, passwordLabel;
    private Doctor doctor;
    private User user;

    public DoctorFrame(Doctor doctor, User loginUser) {
        //初始化医生个人信息
        this.doctor = doctor;
        //医生用户信息
        this.user = loginUser;
        //设置窗口
        setTitle("医生个人信息系统");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // 将组件添加到布局中
        JPanel panel = new JPanel(new GridLayout(8, 2));
        jobLabel = new JLabel("工号: ");
        jobField = new JTextField();
        nameLabel = new JLabel("名字: ");
        nameField = new JTextField();
        departmentLabel = new JLabel("科室名称: ");
        departmentField = new JTextField();
        phoneLabel = new JLabel("电话号码: ");
        phoneField = new JTextField();
        schoolLabel = new JLabel("毕业院校: ");
        schoolField = new JTextField();
        positionLabel = new JLabel("职位: ");
        positionField = new JTextField();
        passwordLabel = new JLabel("密码: ");
        passwordTextField = new JTextField();
        viewButton = new JButton("查看信息");
        updateButton = new JButton("修改密码");
        // 将组件添加到面板中
        panel.add(jobLabel);
        panel.add(jobField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(departmentLabel);
        panel.add(departmentField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(schoolLabel);
        panel.add(schoolField);
        panel.add(positionLabel);
        panel.add(positionField);
        panel.add(passwordLabel);
        panel.add(passwordTextField);
        panel.add(viewButton);
        panel.add(updateButton);
        // 添加面板到窗口中
        add(panel);
        // 向按钮添加操作的监听器
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        // 显示窗口
        setVisible(true);
    }

    // 按钮的处理事件
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewButton) {
            // 获取医生数据
            String jodId = doctor.getJobId();
            String name = doctor.getName();
            String department = doctor.getDepartment();
            int phone = doctor.getPhoneNumber();
            String school = doctor.getGraduateSchool();
            String position = doctor.getPosition();
            String password = user.getPassword();
            // 展示医生数据
            jobField.setText(jodId);
            nameField.setText(name);
            departmentField.setText(department);
            phoneField.setText(String.valueOf(phone));
            schoolField.setText(school);
            positionField.setText(position);
            passwordTextField.setText(password);
        } else if (e.getSource() == updateButton) {
            String newPassword = JOptionPane.showInputDialog(null, "输入新密码:");
            if (newPassword != null && newPassword != "") {
                //展示新密码 以及更新用户密码
                passwordTextField.setText(newPassword);
                this.user.setPassword(passwordTextField.getText());
                // 更新密码
                JOptionPane.showMessageDialog(null, "密码更新成功!");
            }else {
                JOptionPane.showMessageDialog(null,"更新失败");
            }
        }
    }

}