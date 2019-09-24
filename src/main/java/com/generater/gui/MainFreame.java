package com.generater.gui;

import javax.swing.*;
import java.awt.*;

public class MainFreame {
    private JFrame frame;
    private void createMainBoard(){
        frame = new JFrame();
    }

    private void addComponents(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(300,500);
        panel.setBackground(Color.pink);

        JButton button = new JButton("提交");
        button.setBounds(150, 300, 300, 40);

        JTextField url = new JTextField("请输入数据库url");
        url.setSize(120, 10);
        url.setBounds(150, 100, 300, 40);

        JTextField username = new JTextField("请输入数据库用户名");
        username.setSize(120, 10);
        username.setBounds(150, 150, 300, 40);

        JTextField password = new JTextField("请输入数据库密码");
        password.setSize(120, 10);
        password.setBounds(150, 200, 300, 40);

        JTextField dbName = new JTextField("请输入数据库名称");
        dbName.setSize(120, 10);
        dbName.setBounds(150, 250, 300, 40);


        panel.add(url);
        panel.add(username);
        panel.add(password);
        panel.add(dbName);
        panel.add(button);
        frame.add(panel);
    }

    private void init(){
        frame.setTitle("自动生成java文件");
        frame.setVisible(Boolean.TRUE);
        frame.setSize(800,600);
        frame.setResizable(Boolean.TRUE);

    }
    public static void main(String args[]) throws Exception{
        MainFreame main = new MainFreame();
        main.createMainBoard();
        main.addComponents();
        main.init();
    }
}
