package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    JButton back, update, check;

    UpdateCheck() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 875, 450);
        panel.setBackground(new Color(39, 40, 41));
        add(panel);

        JLabel UpdateCheckLabel = new JLabel("Update Check-in Details");
        UpdateCheckLabel.setBounds(320, 0, 875, 40);
        UpdateCheckLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        UpdateCheckLabel.setForeground(new Color(255, 255, 255));
        panel.add(UpdateCheckLabel);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(img);
        JLabel label = new JLabel(icon2);
        label.setBounds(550, 130, 200, 200);
        panel.add(label);

        JLabel id = new JLabel("ID");
        id.setBounds(50, 70, 100, 30);
        id.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        id.setForeground(new Color(255, 255, 255));
        panel.add(id);

        Choice c = new Choice();
        c.setBounds(200, 70, 150, 30);
        panel.add(c);

        try {
            Con con = new Con();
            ResultSet rs = con.statement.executeQuery("select * from customer");
            while (rs.next()) {
                c.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel room = new JLabel("Room Number");
        room.setBounds(50, 120, 100, 30);
        room.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        room.setForeground(new Color(255, 255, 255));
        panel.add(room);

        JTextField roomNumber = new JTextField();
        roomNumber.setBounds(200, 120, 150, 30);
        roomNumber.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNumber.setBackground(new Color(105, 105, 105));
        roomNumber.setForeground(new Color(255, 255, 255));
        panel.add(roomNumber);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 170, 100, 30);
        name.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        name.setForeground(new Color(255, 255, 255));
        panel.add(name);

        JTextField nameF = new JTextField();
        nameF.setBounds(200, 170, 150, 30);
        nameF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nameF.setBackground(new Color(105, 105, 105));
        nameF.setForeground(new Color(255, 255, 255));
        panel.add(nameF);

        JLabel amount = new JLabel("Amount Paid");
        amount.setBounds(50, 220, 100, 30);
        amount.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        amount.setForeground(new Color(255, 255, 255));
        panel.add(amount);

        JTextField amountF = new JTextField();
        amountF.setBounds(200, 220, 150, 30);
        amountF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        amountF.setBackground(new Color(105, 105, 105));
        amountF.setForeground(new Color(255, 255, 255));
        panel.add(amountF);

        JLabel pending = new JLabel("Due Amount");
        pending.setBounds(50, 270, 150, 30);
        pending.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pending.setForeground(new Color(255, 255, 255));
        panel.add(pending);

        JTextField pendingF = new JTextField();
        pendingF.setBounds(200, 270, 150, 30);
        pendingF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pendingF.setBackground(new Color(105, 105, 105));
        pendingF.setForeground(new Color(255, 255, 255));
        panel.add(pendingF);

        JLabel checkIn = new JLabel("Check-In");
        checkIn.setBounds(50, 320, 100, 30);
        checkIn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        checkIn.setForeground(new Color(255, 255, 255));
        panel.add(checkIn);

        JTextField checkInF = new JTextField();
        checkInF.setBounds(200, 320, 150, 30);
        checkInF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        checkInF.setBackground(new Color(105, 105, 105));
        checkInF.setForeground(new Color(255, 255, 255));
        panel.add(checkInF);

        back = new JButton("Back");
        back.setBounds(5, 463, 95, 30);
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

        update = new JButton("Update");
        update.setBounds(779, 463, 100, 30);
        update.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        update.setBackground(new Color(255, 255, 255));
        update.setForeground(new Color(0, 0, 0));
        update.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con con = new Con();
                    String id = c.getSelectedItem();
                    String roomNumberText = roomNumber.getText();
                    String nameText = nameF.getText();
                    String amountText = amountF.getText();
                    String checkInText = checkInF.getText();

                    // Check if the room is occupied
                    String currentRoomNumber = roomNumber.getText();
                    if (!currentRoomNumber.equals(roomNumberText)) {
                        ResultSet rs = con.statement.executeQuery("SELECT availability FROM room WHERE roomnumber = '" + roomNumberText + "'");
                        if (rs.next()) {
                            String availability = rs.getString("availability");
                            if ("occupied".equalsIgnoreCase(availability)) {
                                JOptionPane.showMessageDialog(null, "Room is already occupied and cannot be updated.");
                                return;
                            }
                        }
                    }

                    // Update the customer table
                    con.statement.executeUpdate("UPDATE customer SET room_number = '" + roomNumberText + "', name = '" + nameText + "', created_at = '" + checkInText + "', deposit = '" + amountText + "' WHERE id = '" + id + "'");

                    // Update the room table and set availability to occupied
                    con.statement.executeUpdate("UPDATE room SET availability = 'occupied' WHERE roomnumber = '" + roomNumberText + "'");

                    JOptionPane.showMessageDialog(null, "Data Updated Successfully");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        check = new JButton("Check");
        check.setBounds(674, 463, 100, 30);
        check.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        check.setBackground(new Color(255, 255, 255));
        check.setForeground(new Color(0, 0, 0));
        check.setBorder(BorderFactory.createLineBorder(new Color(39, 40, 41, 255), 2));
        add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Con con = new Con();
                    String id = c.getSelectedItem(); // Get selected customer ID
                    String str = "select * from customer where id = '" + id + "'";
                    ResultSet rs = con.statement.executeQuery(str);

                    // Check if customer data exists
                    if (rs.next()) {
                        nameF.setText(rs.getString("name"));
                        roomNumber.setText(rs.getString("room_number"));
                        amountF.setText(rs.getString("deposit")); // Deposit (DECIMAL) is set to amountF field
                        checkInF.setText(rs.getString("created_at"));
                    }

                    String roomNumberText = roomNumber.getText();
                    if (!roomNumberText.isEmpty()) {
                        // Query the room table for the price (VARCHAR)
                        ResultSet rs2 = con.statement.executeQuery("select * from room where roomnumber = '" + roomNumberText + "'");

                        if (rs2.next()) {
                            // Get the room price as a VARCHAR
                            String price = rs2.getString("price");

                            // Convert price (VARCHAR) to double
                            double roomPrice = Double.parseDouble(price);

                            // Convert deposit (DECIMAL) to double
                            double depositAmount = Double.parseDouble(amountF.getText());

                            // Subtract deposit from room price to get pending amount
                            double pendingAmount = roomPrice - depositAmount;

                            // Set the pending amount to the pendingF field
                            pendingF.setText(String.valueOf(pendingAmount));
                        }
                    }

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
        new UpdateCheck();
    }
}
