package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut extends JFrame {
    Choice customerChoice;
    JTextField roomNumberField, checkOutTimeField;
    JButton checkOutButton, backButton;

    CheckOut() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 450);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel checkOutLabel = new JLabel("Check Out");
        checkOutLabel.setBounds(370, 0, 875, 40);
        checkOutLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        checkOutLabel.setForeground(new Color(255, 255, 255));
        panel.add(checkOutLabel);

        JLabel customerLabel = new JLabel("Customer ID");
        customerLabel.setBounds(50, 70, 100, 30);
        customerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        customerLabel.setForeground(new Color(255, 255, 255));
        panel.add(customerLabel);

        customerChoice = new Choice();
        loadCustomerIDs();
        customerChoice.setBounds(200, 70, 150, 30);
        customerChoice.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        customerChoice.setBackground(new Color(105, 105, 105));
        customerChoice.setForeground(new Color(255, 255, 255));
        customerChoice.addItemListener(e -> loadCustomerDetails());
        panel.add(customerChoice);

        JLabel roomNumberLabel = new JLabel("Room Number");
        roomNumberLabel.setBounds(50, 120, 100, 30);
        roomNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNumberLabel.setForeground(new Color(255, 255, 255));
        panel.add(roomNumberLabel);

        roomNumberField = new JTextField();
        roomNumberField.setBounds(200, 120, 150, 30);
        roomNumberField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNumberField.setBackground(new Color(105, 105, 105));
        roomNumberField.setForeground(new Color(255, 255, 255));
        roomNumberField.setEditable(false);
        panel.add(roomNumberField);

        JLabel checkOutTimeLabel = new JLabel("Check Out Time");
        checkOutTimeLabel.setBounds(50, 170, 150, 30);
        checkOutTimeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        checkOutTimeLabel.setForeground(new Color(255, 255, 255));
        panel.add(checkOutTimeLabel);

        checkOutTimeField = new JTextField();
        checkOutTimeField.setBounds(200, 170, 150, 30);
        checkOutTimeField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        checkOutTimeField.setBackground(new Color(105, 105, 105));
        checkOutTimeField.setForeground(new Color(255, 255, 255));
        panel.add(checkOutTimeField);

        checkOutButton = new JButton("Check Out");
        checkOutButton.setBounds(200, 260, 120, 30);
        checkOutButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        checkOutButton.setBackground(new Color(39, 40, 41));
        checkOutButton.setForeground(new Color(255, 255, 255));
        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkOutCustomer();
            }
        });
        panel.add(checkOutButton);

        backButton = new JButton("Back");
        backButton.setBounds(70, 260, 120, 30);
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        backButton.setBackground(new Color(39, 40, 41));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(backButton);

        setLayout(null);
        setUndecorated(true);
        setSize(885, 460);
        setLocation(400, 120);
        setVisible(true);
    }

    private void loadCustomerIDs() {
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT id FROM customer");
            while (rs.next()) {
                customerChoice.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCustomerDetails() {
        String customerID = customerChoice.getSelectedItem();
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("SELECT room_number FROM customer WHERE id = '" + customerID + "'");
            if (rs.next()) {
                roomNumberField.setText(rs.getString("room_number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkOutCustomer() {
        String customerID = customerChoice.getSelectedItem();
        String roomNumber = roomNumberField.getText();
        String checkOutTime = checkOutTimeField.getText();

        // Validate the datetime input or auto-generate the current time
        if (checkOutTime.isEmpty()) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            checkOutTime = now.format(formatter);
        }

        try {
            Con c = new Con();

            // Retrieve the room price
            String roomPriceQuery = "SELECT price FROM room WHERE roomnumber = ?";
            PreparedStatement psRoomPrice = c.statement.getConnection().prepareStatement(roomPriceQuery);
            psRoomPrice.setString(1, roomNumber);
            ResultSet rsRoomPrice = psRoomPrice.executeQuery();
            double roomPrice = 0;
            if (rsRoomPrice.next()) {
                roomPrice = Double.parseDouble(rsRoomPrice.getString("price"));
            }

            // Retrieve the deposit amount
            String depositQuery = "SELECT deposit FROM customer WHERE id = ?";
            PreparedStatement psDeposit = c.statement.getConnection().prepareStatement(depositQuery);
            psDeposit.setString(1, customerID);
            ResultSet rsDeposit = psDeposit.executeQuery();
            double depositAmount = 0;
            if (rsDeposit.next()) {
                depositAmount = rsDeposit.getDouble("deposit");
            }

            // Check if room price is equal to deposit amount
            if (roomPrice != depositAmount) {
                JOptionPane.showMessageDialog(null, "Full payment not complete yet. Cannot proceed with checkout.");
                return;
            }

            // Update customer check_out_time using PreparedStatement
            String updateCustomerQuery = "UPDATE customer SET check_out_time = ? WHERE id = ?";
            PreparedStatement psCustomer = c.statement.getConnection().prepareStatement(updateCustomerQuery);
            psCustomer.setString(1, checkOutTime);
            psCustomer.setString(2, customerID);
            psCustomer.executeUpdate();

            // Update room availability
            String updateRoomQuery = "UPDATE room SET availability = 'available' WHERE roomnumber = ?";
            PreparedStatement psRoom = c.statement.getConnection().prepareStatement(updateRoomQuery);
            psRoom.setString(1, roomNumber);
            psRoom.executeUpdate();

            JOptionPane.showMessageDialog(null, "Check Out Successful");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}