package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import net.proteanit.sql.DbUtils;

public class CustomerInfo extends JFrame {
    JTable table;
    JButton back;

    CustomerInfo() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 450);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel CustomerInfoLabel = new JLabel("Customer Info");
        CustomerInfoLabel.setBounds(370, 0, 875, 40);
        CustomerInfoLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        CustomerInfoLabel.setForeground(new Color(255, 255, 255));
        panel.add(CustomerInfoLabel);

        table = new JTable();
        table.setBackground(new Color(39, 40, 41));
        table.setForeground(new Color(255, 255, 255));
        table.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        table.setFont(new Font("Helvetica", Font.PLAIN, 15));

        // Hide the JTable header to keep only the manual heading
        table.setTableHeader(null);

        JScrollPane scrollPane = new JScrollPane(table);  // Add table to scroll pane
        scrollPane.setBounds(0, 70, 875, 380);  // Set bounds for scroll pane instead of table
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        panel.add(scrollPane);  // Add scroll pane to the panel

        loadCustomerData();

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

        JLabel id=new JLabel("ID");
        id.setBounds(40,40,100,30);
        id.setFont(new Font("Helvetica",Font.PLAIN,14));
        id.setForeground(new Color(255,255,255));
        panel.add(id);

        JLabel name=new JLabel("Name");
        name.setBounds(100,40,100,30);
        name.setFont(new Font("Helvetica",Font.PLAIN,14));
        name.setForeground(new Color(255,255,255));
        panel.add(name);

        JLabel type=new JLabel("Type");
        type.setBounds(180,40,100,30);
        type.setFont(new Font("Helvetica",Font.PLAIN,14));
        type.setForeground(new Color(255,255,255));
        panel.add(type);

        JLabel number=new JLabel("Number");
        number.setBounds(258,40,100,30);
        number.setFont(new Font("Helvetica",Font.PLAIN,14));
        number.setForeground(new Color(255,255,255));
        panel.add(number);

        JLabel contact=new JLabel("Contact");
        contact.setBounds(323,40,100,30);
        contact.setFont(new Font("Helvetica",Font.PLAIN,14));
        contact.setForeground(new Color(255,255,255));
        panel.add(contact);

        JLabel gender=new JLabel("Gender");
        gender.setBounds(410,40,100,30);
        gender.setFont(new Font("Helvetica",Font.PLAIN,14));
        gender.setForeground(new Color(255,255,255));
        panel.add(gender);

        JLabel country=new JLabel("Country");
        country.setBounds(490,40,100,30);
        country.setFont(new Font("Helvetica",Font.PLAIN,14));
        country.setForeground(new Color(255,255,255));
        panel.add(country);

        JLabel room=new JLabel("Room");
        room.setBounds(580,40,100,30);
        room.setFont(new Font("Helvetica",Font.PLAIN,14));
        room.setForeground(new Color(255,255,255));
        panel.add(room);

        JLabel deposit=new JLabel("Deposit");
        deposit.setBounds(650,40,100,30);
        deposit.setFont(new Font("Helvetica",Font.PLAIN,14));
        deposit.setForeground(new Color(255,255,255));
        panel.add(deposit);

        JLabel checkin=new JLabel("Checkin");
        checkin.setBounds(730,40,100,30);
        checkin.setFont(new Font("Helvetica",Font.PLAIN,14));
        checkin.setForeground(new Color(255,255,255));
        panel.add(checkin);

        JLabel checkout=new JLabel("Checkout");
        checkout.setBounds(800,40,100,30);
        checkout.setFont(new Font("Helvetica",Font.PLAIN,14));
        checkout.setForeground(new Color(255,255,255));
        panel.add(checkout);


        setLayout(null);
        setUndecorated(true);
        setSize(885, 500);
        setLocation(400, 120);
        setVisible(true);
    }

    // Method to load data from the customer table
    private void loadCustomerData() {
        try {
            Con c = new Con();
            String query = "SELECT * FROM customer";
            ResultSet rs = c.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new CustomerInfo();
    }
}