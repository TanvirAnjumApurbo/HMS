package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {

    Reception() {
        super("Fontainebleau Reception");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280, 5, 1082, 687);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 270, 687);
        panel1.setBackground(new Color(39, 40, 41));
        add(panel1);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/login.gif"));
        Image i1 = icon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label = new JLabel(i2);
        label.setBounds(300, 70, 500, 500);
        panel.add(label);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icon/logoletter.png"));
        Image i3 = icon1.getImage().getScaledInstance(230, 100, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel label1 = new JLabel(i4);
        label1.setBounds(16, 580, 230, 100);
        panel1.add(label1);

        JButton buttonNCF = new JButton("New Customer Form");
        buttonNCF.setBounds(20, 30, 230, 30);
        buttonNCF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonNCF.setBackground(new Color(39, 40, 41));
        buttonNCF.setForeground(new Color(255, 255, 255));
        buttonNCF.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonNCF);
        buttonNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewCustomer();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton buttonRoom = new JButton("Room");
        buttonRoom.setBounds(20, 70, 230, 30);
        buttonRoom.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonRoom.setBackground(new Color(39, 40, 41));
        buttonRoom.setForeground(new Color(255, 255, 255));
        buttonRoom.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonRoom);
        buttonRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

//        JButton buttonDepartment = new JButton("Employee");
//        buttonDepartment.setBounds(20, 110, 230, 30);
//        buttonDepartment.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        buttonDepartment.setBackground(new Color(39, 40, 41));
//        buttonDepartment.setForeground(new Color(255, 255, 255));
//        buttonDepartment.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
//        panel1.add(buttonDepartment);
//        buttonDepartment.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });

        JButton buttonAllEmployeeInfo = new JButton("All Employee Info");
        buttonAllEmployeeInfo.setBounds(20, 110, 230, 30);
        buttonAllEmployeeInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonAllEmployeeInfo.setBackground(new Color(39, 40, 41));
        buttonAllEmployeeInfo.setForeground(new Color(255, 255, 255));
        buttonAllEmployeeInfo.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonAllEmployeeInfo);
        buttonAllEmployeeInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Employee();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton buttonCustomerInfo = new JButton("Customer Info");
        buttonCustomerInfo.setBounds(20, 150, 230, 30);
        buttonCustomerInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonCustomerInfo.setBackground(new Color(39, 40, 41));
        buttonCustomerInfo.setForeground(new Color(255, 255, 255));
        buttonCustomerInfo.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonCustomerInfo);
        buttonCustomerInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

//        JButton buttonManagerInfo = new JButton("Manager Info");
//        buttonManagerInfo.setBounds(20, 230, 230, 30);
//        buttonManagerInfo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        buttonManagerInfo.setBackground(new Color(39, 40, 41));
//        buttonManagerInfo.setForeground(new Color(255, 255, 255));
//        buttonManagerInfo.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
//        panel1.add(buttonManagerInfo);
//        buttonManagerInfo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });

        JButton buttonCheckOut = new JButton("Check Out");
        buttonCheckOut.setBounds(20, 190, 230, 30);
        buttonCheckOut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonCheckOut.setBackground(new Color(39, 40, 41));
        buttonCheckOut.setForeground(new Color(255, 255, 255));
        buttonCheckOut.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonCheckOut);
        buttonCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckOut();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JButton buttonUpdateCheckStatus = new JButton("Update Check-In Status");
        buttonUpdateCheckStatus.setBounds(20, 230, 230, 30);
        buttonUpdateCheckStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonUpdateCheckStatus.setBackground(new Color(39, 40, 41));
        buttonUpdateCheckStatus.setForeground(new Color(255, 255, 255));
        buttonUpdateCheckStatus.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonUpdateCheckStatus);
        buttonUpdateCheckStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

//        JButton buttonUpdateRoomStatus = new JButton("Update Room Status");
//        buttonUpdateRoomStatus.setBounds(20, 350, 230, 30);
//        buttonUpdateRoomStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        buttonUpdateRoomStatus.setBackground(new Color(39, 40, 41));
//        buttonUpdateRoomStatus.setForeground(new Color(255, 255, 255));
//        buttonUpdateRoomStatus.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
//        panel1.add(buttonUpdateRoomStatus);
//        buttonUpdateRoomStatus.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });

        JButton buttonPickUpService = new JButton("Pick Up Service");
        buttonPickUpService.setBounds(20, 270, 230, 30);
        buttonPickUpService.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        buttonPickUpService.setBackground(new Color(39, 40, 41));
        buttonPickUpService.setForeground(new Color(255, 255, 255));
        buttonPickUpService.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        panel1.add(buttonPickUpService);
        buttonPickUpService.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Pickup();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

//        JButton buttonSearchRoom = new JButton("Search Room");
//        buttonSearchRoom.setBounds(20, 430, 230, 30);
//        buttonSearchRoom.setFont(new Font("Segoe UI", Font.PLAIN, 15));
//        buttonSearchRoom.setBackground(new Color(39, 40, 41));
//        buttonSearchRoom.setForeground(new Color(255, 255, 255));
//        buttonSearchRoom.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
//        panel1.add(buttonSearchRoom);
//        buttonSearchRoom.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//            }
//        });


        getContentPane().setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1950, 1090);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception();
    }
}