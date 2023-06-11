package com.gxuwz.Frame;

import com.gxuwz.entity.Doctor;
import com.gxuwz.entity.User;
import com.gxuwz.util.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginFrame extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;
    private Data data;

    public LoginFrame(Data data) {
        //获取数据
        this.data = data;

        //设置标题、大小以及关闭操作
        setTitle("登录");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //设置两行三列的布局
        JPanel panel = new JPanel(new GridLayout(3, 2));

        //添加“账号”文本框
        JLabel usernameLabel = new JLabel("账号:");
        panel.add(usernameLabel);
        usernameField = new JTextField(20);
        panel.add(usernameField);

        //添加“密码”文本框
        JLabel passwordLabel = new JLabel("密码:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField(20);
        panel.add(passwordField);

        //添加登录按钮
        loginButton = new JButton("登录");
        loginButton.setActionCommand("登录");
        loginButton.addActionListener(this);
        panel.add(loginButton);

        //添加取消按钮
        cancelButton = new JButton("取消");
        cancelButton.setActionCommand("取消");
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        //将布局加入窗口内
        //设置窗口屏幕居中
        //设置窗口可见
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //判断是哪个事件
        if (e.getActionCommand().equals("登录")) {
            // 获取文本框里的数据
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            //获取登录的用户
            User loginUser = Arrays.stream(data.getUsers())
                    .filter(user -> user.getUsername().equals(username) && user.getPassword().equals(password))
                    .findFirst().get();

            //判断用户的角色
            if (loginUser.getRole() == "系统管理员"){
                AdminFrame adminFrame = new AdminFrame(data);
                this.setVisible(false);
            }else if (loginUser.getRole() == "医生"){
                //从用户中获取医生信息
                Doctor doctor = Arrays.stream(data.getDoctors()).filter(d -> d.getJobId().equals(loginUser.getUsername())).findFirst().get();
                DoctorFrame doctorFrame = new DoctorFrame(doctor, loginUser);
                this.setVisible(false);
            }else {
            }
        } else if (e.getActionCommand().equals("取消")) {
            // 取消按钮被点击
            System.exit(0);
        }
    }
}