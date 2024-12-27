package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame implements ActionListener {
    Choice locationChoice, availableDriverChoice, assignedDriverChoice;
    JButton assignDriver, markAvailable, back;

    Pickup() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 490);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel label = new JLabel("Assign Driver for Pickup");
        label.setBounds(310, 10, 250, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(new Color(255, 255, 255));
        panel.add(label);

        JLabel locationLabel = new JLabel("Select Location");
        locationLabel.setBounds(50, 70, 110, 30);
        locationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        locationLabel.setForeground(new Color(255, 255, 255));
        panel.add(locationLabel);

        locationChoice = new Choice();
        loadLocations();
        locationChoice.setBounds(200, 70, 150, 30);
        locationChoice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        locationChoice.setBackground(new Color(105, 105, 105));
        locationChoice.setForeground(new Color(255, 255, 255));
        locationChoice.addItemListener(e -> {
            loadAvailableDrivers();
            loadAssignedDrivers();
        });
        panel.add(locationChoice);

        JLabel availableDriverLabel = new JLabel("Available Drivers");
        availableDriverLabel.setBounds(50, 120, 150, 30);
        availableDriverLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        availableDriverLabel.setForeground(new Color(255, 255, 255));
        panel.add(availableDriverLabel);

        availableDriverChoice = new Choice();
        availableDriverChoice.setBounds(200, 120, 150, 30);
        availableDriverChoice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        availableDriverChoice.setBackground(new Color(105, 105, 105));
        availableDriverChoice.setForeground(new Color(255, 255, 255));
        panel.add(availableDriverChoice);

        JLabel assignedDriverLabel = new JLabel("Assigned Drivers");
        assignedDriverLabel.setBounds(520, 120, 150, 30);
        assignedDriverLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        assignedDriverLabel.setForeground(new Color(255, 255, 255));
        panel.add(assignedDriverLabel);

        assignedDriverChoice = new Choice();
        assignedDriverChoice.setBounds(670, 120, 150, 30);
        assignedDriverChoice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        assignedDriverChoice.setBackground(new Color(105, 105, 105));
        assignedDriverChoice.setForeground(new Color(255, 255, 255));
        panel.add(assignedDriverChoice);

        assignDriver = new JButton("Assign Driver");
        assignDriver.setBounds(110, 170, 150, 30);
        assignDriver.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        assignDriver.setBackground(new Color(39, 40, 41));
        assignDriver.setForeground(new Color(255, 255, 255));
        assignDriver.addActionListener(this);
        panel.add(assignDriver);

        markAvailable = new JButton("Mark Available");
        markAvailable.setBounds(600, 170, 150, 30);
        markAvailable.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        markAvailable.setBackground(new Color(39, 40, 41));
        markAvailable.setForeground(new Color(255, 255, 255));
        markAvailable.addActionListener(this);
        panel.add(markAvailable);

        back = new JButton("Back");
        back.setBounds(350, 420, 150, 30);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setBackground(new Color(39, 40, 41));
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setUndecorated(true);
        setSize(885, 500);
        setLocation(400, 120);
        setVisible(true);
    }

    private void loadLocations() {
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT DISTINCT location FROM drivers");
            while (rs.next()) {
                locationChoice.add(rs.getString("location"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAvailableDrivers() {
        availableDriverChoice.removeAll();
        String selectedLocation = locationChoice.getSelectedItem();
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM drivers WHERE available = 'Yes' AND location = '" + selectedLocation + "'");
            while (rs.next()) {
                availableDriverChoice.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAssignedDrivers() {
        assignedDriverChoice.removeAll();
        String selectedLocation = locationChoice.getSelectedItem();
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM drivers WHERE available = 'No' AND location = '" + selectedLocation + "'");
            while (rs.next()) {
                assignedDriverChoice.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == assignDriver) {
            String driverName = availableDriverChoice.getSelectedItem();
            try {
                Con c = new Con();
                String query = "UPDATE drivers SET available = 'No' WHERE name = '" + driverName + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Assigned Successfully");
                loadAvailableDrivers();
                loadAssignedDrivers();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == markAvailable) {
            String driverName = assignedDriverChoice.getSelectedItem();
            try {
                Con c = new Con();
                String query = "UPDATE drivers SET available = 'Yes' WHERE name = '" + driverName + "'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver Marked as Available");
                loadAvailableDrivers();
                loadAssignedDrivers();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Pickup();
    }
}