package com.gxuwz.Frame;

import com.gxuwz.util.Data;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class AdminFrame extends JFrame implements ActionListener {
    private JTabbedPane tabbedPane;
    private JPanel deptPanel, doctorPanel, userPanel;
    private JLabel deptLabel, doctorLabel, userLabel;
    private JTextField deptTextField, doctorTextField, userTextField;
    private JButton addDeptButton, deleteDeptButton, addDoctorButton, deleteDoctorButton, addUserButton, deleteUserButton, checkDeptButton, checkUserButton, checkDoctorButton;
    private JTable deptTable, doctorTable, userTable;
    private DefaultTableModel deptModel,doctorModel,userModel;
    private Data data;

    public AdminFrame(Data data) {
        this.data = data;
        setTitle("后台管理系统");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 创建选项卡
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);

        // 创建科室信息管理面板
        deptPanel = new JPanel(new BorderLayout());

        // 创建 科室信息管理面板的 文本和文本框
        JPanel deptInfoPanel = new JPanel(new GridLayout(1, 2));
        deptLabel = new JLabel("搜索关键词:");
        deptInfoPanel.add(deptLabel);
        deptTextField = new JTextField(10);
        deptInfoPanel.add(deptTextField);

        // 将文本框和文本 添加 到科室信息管理 的最上方
        deptPanel.add(deptInfoPanel, BorderLayout.NORTH);

        // 创建 科室信息管理面板 的按钮
        JPanel deptButtonPanel = new JPanel();
        addDeptButton = new JButton("添加");
        addDeptButton.setActionCommand("添加科室");
        addDeptButton.addActionListener(this::actionPerformed);//设置 “添加科室” 监听命令
        deptButtonPanel.add(addDeptButton);
        deleteDeptButton = new JButton("删除");
        deleteDeptButton.setActionCommand("删除科室");
        deleteDeptButton.addActionListener(this::actionPerformed);//设置 “删除科室” 监听命令
        deptButtonPanel.add(deleteDeptButton);
        checkDeptButton = new JButton("查找");
        checkDeptButton.setActionCommand("查找科室");
        checkDeptButton.addActionListener(this::actionPerformed);//设置“查找科室” 监听命令
        deptButtonPanel.add(checkDeptButton);

        //将按钮 添加到 科室信息管理 最下方
        deptPanel.add(deptButtonPanel, BorderLayout.SOUTH);

        // 创建 科室信息管理面板 的表格 并初始化表格
        deptModel = new DefaultTableModel(Arrays.stream(data.getDepartments()).map(department -> new Object[]{department.getId(), department.getName()}).toArray(Object[][]::new), new Object[]{"ID", "科室名称"});
        deptTable = new JTable(deptModel);

        // 将按钮 添加到 科室信息管理面板 的中间
        deptPanel.add(new JScrollPane(deptTable), BorderLayout.CENTER);

        // 添加 科室信息管理面板 到选项卡当中
        tabbedPane.addTab("科室信息管理面板", deptPanel);

        // 创建 医生信息管理面板
        doctorPanel = new JPanel(new BorderLayout());

        // 创建 医生信息管理面板 的文本和文本框
        JPanel doctorInfoPanel = new JPanel(new GridLayout(1,2));
        doctorLabel = new JLabel("搜索关键词:");
        doctorInfoPanel.add(doctorLabel);
        doctorTextField = new JTextField(10);
        doctorInfoPanel.add(doctorTextField);

        // 将文本和文本框 添加到 医生信息管理面板的最上方
        doctorPanel.add(doctorInfoPanel, BorderLayout.NORTH);

        // 创建 医生信息管理面板 的按钮
        JPanel doctorButtonPanel = new JPanel();
        addDoctorButton = new JButton("添加");
        addDoctorButton.setActionCommand("添加医生");
        addDoctorButton.addActionListener(this::actionPerformed); // 设置 “添加医生” 监听命令
        doctorButtonPanel.add(addDoctorButton);
        deleteDoctorButton = new JButton("删除");
        deleteDoctorButton.setActionCommand("删除医生");
        deleteDoctorButton.addActionListener(this::actionPerformed); // 设置 ”删除医生“ 监听命令
        doctorButtonPanel.add(deleteDoctorButton);
        checkDoctorButton = new JButton("查找");
        checkDoctorButton.setActionCommand("查找医生");
        checkDoctorButton.addActionListener(this::actionPerformed); // 设置 "查找医生" 监听命令
        doctorButtonPanel.add(checkDoctorButton);

        // 将按钮 添加到 医生信息管理面板 的最下方
        doctorPanel.add(doctorButtonPanel, BorderLayout.SOUTH);

        // 创建 医生信息管理 的表格 并初始化表格
        doctorModel = new DefaultTableModel(Arrays.stream(data.getDoctors())
                .map(doctor -> new Object[]{doctor.getId(), doctor.getName(), doctor.getJobId(), doctor.getGender(), doctor.getDepartment(), doctor.getPhoneNumber(), doctor.getGraduateSchool(), doctor.getPosition()}).toArray(Object[][]::new), new Object[]{"ID", "姓名","工号(账号)","性别","科室","电话号码","毕业院校","职位"});
        doctorTable = new JTable(doctorModel);

        // 将表格 添加到 医生信息管理面板的 中间
        doctorPanel.add(new JScrollPane(doctorTable), BorderLayout.CENTER);

        //将 医生信息管理面板添加到 选项卡当中
        tabbedPane.addTab("医生信息管理面板", doctorPanel);

        // 创建 用户管理面板
        userPanel = new JPanel(new BorderLayout());

        // 创建 用户信息管理 的文本和文本框
        JPanel userInfoPanel = new JPanel(new GridLayout(1, 2));
        userLabel = new JLabel("搜索关键词:");
        userInfoPanel.add(userLabel);
        userTextField = new JTextField(10);
        userInfoPanel.add(userTextField);

        // 将文本和文本框 添加到 用户信息管理面板 的最北方
        userPanel.add(userInfoPanel, BorderLayout.NORTH);

        // 创建 用户信息管理面板 的按钮
        JPanel userButtonPanel = new JPanel();
        addUserButton = new JButton("添加");
        addUserButton.setActionCommand("添加用户");
        addUserButton.addActionListener(this::actionPerformed);
        userButtonPanel.add(addUserButton);
        deleteUserButton = new JButton("删除");
        deleteUserButton.setActionCommand("删除用户");
        deleteUserButton.addActionListener(this::actionPerformed);
        userButtonPanel.add(deleteUserButton);
        checkUserButton = new JButton("查找");
        checkUserButton.setActionCommand("查找用户");
        checkUserButton.addActionListener(this::actionPerformed);
        userButtonPanel.add(checkUserButton);

        // 将按钮 添加到 用户信息管理的 最南方
        userPanel.add(userButtonPanel, BorderLayout.SOUTH);

        // 创建 用户信息管理 的表格 并初始化表格
        userModel = new DefaultTableModel(Arrays.stream(data.getUsers()).map(user -> new Object[]{user.getId(),user.getUsername(),user.getPassword(),user.getRole()}).toArray(Object[][]::new),new Object[]{"ID", "账号", "密码", "系统角色"});
        userTable = new JTable(userModel);

        // 将表格 添加到 用户信息管理面板 的中间
        userPanel.add(new JScrollPane(userTable), BorderLayout.CENTER);

        // 将用户信息管理面板 添加到选项卡之中
        tabbedPane.addTab("用户信息管理面板", userPanel);

        //将窗口设置为可见
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //判断监听命令 科室的
        if (e.getActionCommand().equals("添加科室")) {
            deptTable.setModel(deptModel); // 更新 model数据
            deptModel.addRow(new Object[]{}); //添加空行
        } else if (e.getActionCommand().equals("删除科室")) {
            deptTable.setModel(deptModel); //更新 model数据
            Arrays.stream(deptTable.getSelectedRows()).boxed().sorted(Comparator.reverseOrder()).forEach(deptModel::removeRow); // 遍历被选中的行 并移除掉
        } else if (e.getActionCommand().equals("查找科室")){
            Vector<Vector<Object>> dataVector = deptModel.getDataVector(); //获取 model里的数据
            Vector<Vector<Object>> newDataVector = new Vector<>();  // 创建新集合（查询到的结果放在该集合）
            for (int i = 0; i < deptModel.getDataVector().size(); i++) { //遍历第几行 i
                int row = -1;  // 存放 目标行的变量
                for (int j = 0; j < dataVector.get(i).size(); j++) { //遍历第几列 j
                    if (dataVector.get(i).get(j) !=null && dataVector.get(i).get(j).toString().contains(deptTextField.getText())){ //判断单元格内的数据是否包含需要查询的关键字
                        row = i; // 保存包含关键字 行的数据
                    } else if (dataVector.get(i).get(j) == null && deptTextField.getText().equals("")) { // 保存 单元格为空 并且 关键字为 ”“的数据
                        row = i;
                    }
                }
                if (row != -1) {
                    newDataVector.add(dataVector.get(row)); // 保存 寻找到目标行的数据 进新集合
                }
            }
            //创建符合查询的结果的新model
            DefaultTableModel newDeptModel = new DefaultTableModel(newDataVector, new Vector<>(Arrays.asList("ID","科室名称")));
            //将新model的数据展示在表格中
            deptTable.setModel(newDeptModel);
        }

        //判断监听命令 医生的
        if (e.getActionCommand().equals("添加医生")){
            doctorTable.setModel(doctorModel);
            doctorModel.addRow(new Object[]{});
        }else if (e.getActionCommand().equals("删除医生")){
            Arrays.stream(doctorTable.getSelectedRows()).boxed().sorted(Comparator.reverseOrder()).forEach(doctorModel::removeRow);
        } else if (e.getActionCommand().equals("查找医生")) {
            Vector<Vector<Object>> modelData = doctorModel.getDataVector();
            Vector filteredData = new Vector<>();
            for (Vector<Object> objectVector : modelData) {
                int add = 0;
                for (Object o : objectVector){
                    if (o !=null && o.toString().contains(doctorTextField.getText())){
                        add = 1;
                    } else if (o == null && doctorTextField.getText().equals("")) {
                        add = 1;
                    }
                }
                if (add == 1) {
                    filteredData.add(objectVector);
                }
            }
            DefaultTableModel newDoctorModel = new DefaultTableModel(filteredData, new Vector<>(Arrays.asList("ID", "姓名","工号(账号)","性别","科室","电话号码","毕业院校","职位")));
            doctorTable.setModel(newDoctorModel);
        }

        //判断监听命令 用户的
        if (e.getActionCommand().equals("添加用户")){
            userTable.setModel(userModel);
            userModel.addRow(new Object[]{});
        }else if (e.getActionCommand().equals("删除用户")){
            Arrays.stream(userTable.getSelectedRows()).boxed().sorted(Comparator.reverseOrder()).forEach(userModel::removeRow);
        } else if (e.getActionCommand().equals("查找用户")) {
            Vector<Vector<Object>> modelData = userModel.getDataVector();
            Vector filteredData = new Vector<>();
            for (Vector<Object> objectVector : modelData) {
                int add = 0;
                for (Object o : objectVector){
                    if (o !=null && o.toString().contains(userTextField.getText())){
                        add = 1;
                    } else if (o == null && userTextField.getText().equals("")) {
                        add = 1;
                    }
                }
                if (add == 1) {
                    filteredData.add(objectVector);
                }
            }
            DefaultTableModel newUserModel = new DefaultTableModel(filteredData, new Vector<>(Arrays.asList("ID", "账号","密码","系统角色")));
            userTable.setModel(newUserModel);
        }
    }
}
