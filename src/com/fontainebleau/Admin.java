package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton add_Employee, add_Room, add_Driver, logout, back;

    Admin() {
        super("Admin Dashboard");

        add_Employee = new JButton("Add Employee");
        add_Employee.setBounds(250, 180, 180, 30);
        add_Employee.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        add_Employee.setBackground(new Color(39, 40, 41));
        add_Employee.setForeground(new Color(255, 255, 255));
        add_Employee.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        add_Employee.addActionListener(this);
        add(add_Employee);

        add_Room = new JButton("Add Room");
        add_Room.setBounds(250, 330, 180, 30);
        add_Room.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        add_Room.setBackground(new Color(39, 40, 41));
        add_Room.setForeground(new Color(255, 255, 255));
        add_Room.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Driver = new JButton("Add Driver");
        add_Driver.setBounds(250, 480, 180, 30);
        add_Driver.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        add_Driver.setBackground(new Color(39, 40, 41));
        add_Driver.setForeground(new Color(255, 255, 255));
        add_Driver.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        add_Driver.addActionListener(this);
        add(add_Driver);

        logout = new JButton("Logout");
        logout.setBounds(670, 600, 95, 30);
        logout.setFont(new Font("Segoe UI", Font.BOLD, 15));
        logout.setBackground(new Color(255, 255, 255));
        logout.setForeground(new Color(0, 0, 0));
        logout.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        logout.addActionListener(this);
        add(logout);

//        back = new JButton("Back");
//        back.setBounds(700, 600, 95, 30);
//        back.setFont(new Font("Segoe UI", Font.BOLD, 15));
//        back.setBackground(new Color(255, 255, 255));
//        back.setForeground(new Color(0, 0, 0));
//        back.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
//        back.addActionListener(this);
//        add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employee.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label = new JLabel(i2);
        label.setBounds(70, 140, 120, 120);
        add(label);

        ImageIcon imageIcon1 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i3 = imageIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel label1 = new JLabel(i4);
        label1.setBounds(80, 290, 100, 100);
        add(label1);

        ImageIcon imageIcon2 = new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image i5 = imageIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label2 = new JLabel(i6);
        label2.setBounds(80, 440, 100, 100);
        add(label2);

        ImageIcon imageIcon3 = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i7 = imageIcon3.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i8 = new ImageIcon(i7);
        JLabel label3 = new JLabel(i8);
        label3.setBounds(750, 100, 500, 500);
        add(label3);

        getContentPane().setBackground(new Color(39, 40, 41));
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1950, 1090);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add_Employee) {
            new AddEmployee();

        } else if (e.getSource() == add_Room) {
        new AddRoom();
        } else if (e.getSource() == add_Driver) {
            new AddDriver();

        } else if (e.getSource() == logout) {
            new Login();
            setVisible(false);
        } else {
            new Dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
