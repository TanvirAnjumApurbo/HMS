package com.fontainebleau;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee extends JFrame {
    JTable table;
    JButton back;
    JComboBox<String> filterDropdown, sortDropdown;

    Employee() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 450);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel roomInfoLabel = new JLabel("Employee Info");
        roomInfoLabel.setBounds(370, 0, 875, 40);
        roomInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        roomInfoLabel.setForeground(new Color(255, 255, 255));
        panel.add(roomInfoLabel);

        table = new JTable();
        table.setBackground(new Color(39, 40, 41));
        table.setForeground(new Color(255, 255, 255));
        table.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        table.setFont(new Font("Helvetica", Font.PLAIN, 12));
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); // Enable horizontal scrolling

        // Hide the JTable header to keep only the manual heading
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);  // Add table to scroll pane
        scrollPane.setBounds(0, 70, 875, 380);  // Set bounds for scroll pane instead of table
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        panel.add(scrollPane);  // Add scroll pane to the panel

        try {
            Con c = new Con();
            String str = "select * from employees";
            ResultSet rs = c.statement.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));  // DbUtils is a class in rs2xml.jar
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Manually added labels for the column headers
        JLabel name = new JLabel("Name");
        name.setBounds(50, 40, 100, 30);
        name.setFont(new Font("Helvetica", Font.PLAIN, 14));
        name.setForeground(new Color(255, 255, 255));
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(150, 40, 100, 30);
        age.setFont(new Font("Helvetica", Font.PLAIN, 14));
        age.setForeground(new Color(255, 255, 255));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(250, 40, 100, 30);
        gender.setFont(new Font("Helvetica", Font.PLAIN, 14));
        gender.setForeground(new Color(255, 255, 255));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setBounds(360, 40, 100, 30);
        job.setFont(new Font("Helvetica", Font.PLAIN, 14));
        job.setForeground(new Color(255, 255, 255));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(460, 40, 100, 30);
        salary.setFont(new Font("Helvetica", Font.PLAIN, 14));
        salary.setForeground(new Color(255, 255, 255));
        panel.add(salary);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(575, 40, 100, 30);
        phone.setFont(new Font("Helvetica", Font.PLAIN, 14));
        phone.setForeground(new Color(255, 255, 255));
        panel.add(phone);

        JLabel nid = new JLabel("NID");
        nid.setBounds(700, 40, 100, 30);
        nid.setFont(new Font("Helvetica", Font.PLAIN, 14));
        nid.setForeground(new Color(255, 255, 255));
        panel.add(nid);

        JLabel email = new JLabel("Email");
        email.setBounds(790, 40, 100, 30);
        email.setFont(new Font("Helvetica", Font.PLAIN, 14));
        email.setForeground(new Color(255, 255, 255));
        panel.add(email);

        filterDropdown = new JComboBox<>(new String[]{"All", "Manager"});
        filterDropdown.setBounds(670, 463, 110, 30);
        filterDropdown.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        filterDropdown.setBackground(new Color(255, 255, 255));
        filterDropdown.setForeground(new Color(0, 0, 0));
        filterDropdown.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(filterDropdown);
        filterDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con c = new Con();
                    String selectedItem = (String) filterDropdown.getSelectedItem();
                    String str = "select * from employees";
                    if ("Manager".equals(selectedItem)) {
                        str += " where job = 'Manager'";
                    }
                    ResultSet rs = c.statement.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        sortDropdown = new JComboBox<>(new String[]{"Default", "Sort by Salary", "Sort by Age"});
        sortDropdown.setBounds(555, 463, 110, 30);
        sortDropdown.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        sortDropdown.setBackground(new Color(255, 255, 255));
        sortDropdown.setForeground(new Color(0, 0, 0));
        sortDropdown.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(sortDropdown);
        sortDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con c = new Con();
                    String selectedItem = (String) sortDropdown.getSelectedItem();
                    String str = "select * from employees";
                    if ("Sort by Salary".equals(selectedItem)) {
                        str += " order by salary";
                    } else if ("Sort by Age".equals(selectedItem)) {
                        str += " order by age";
                    }
                    ResultSet rs = c.statement.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        back = new JButton("Back");
        back.setBounds(784, 463, 95, 30);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setBackground(new Color(255, 255, 255));
        back.setForeground(new Color(0, 0, 0));
        back.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    setVisible(false);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        setLayout(null);
        setUndecorated(true);
        setSize(885, 500);
        setLocation(400, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employee();
    }
}