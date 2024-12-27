package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRoom extends JFrame implements ActionListener {

    JTextField roomNoF, priceF;
    JComboBox availabilityF, cleaningStatusF, bedTypeF;
    JButton add, back;

    AddRoom() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 875, 490);
        panel.setBackground(new Color(39, 40, 41));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Add Room");
        label.setBounds(150, 10, 200, 30);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));
        label.setForeground(new Color(255, 255, 255));
        panel.add(label);

        JLabel roomNo = new JLabel("Room No");
        roomNo.setBounds(50, 70, 100, 30);
        roomNo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNo.setForeground(new Color(255, 255, 255));
        panel.add(roomNo);

        roomNoF = new JTextField();
        roomNoF.setBounds(200, 70, 150, 30);
        roomNoF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNoF.setBackground(new Color(105, 105, 105));
        roomNoF.setForeground(new Color(255, 255, 255));
        panel.add(roomNoF);

        JLabel availability = new JLabel("Availability");
        availability.setBounds(50, 120, 100, 30);
        availability.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        availability.setForeground(new Color(255, 255, 255));
        panel.add(availability);

        availabilityF = new JComboBox(new String[]{"Available", "Occupied"});
        availabilityF.setSelectedIndex(-1);
        availabilityF.setBounds(200, 120, 150, 30);
        availabilityF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        availabilityF.setBackground(new Color(105, 105, 105));
        availabilityF.setForeground(new Color(255, 255, 255));
        panel.add(availabilityF);

        JLabel price = new JLabel("Price");
        price.setBounds(50, 170, 100, 30);
        price.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        price.setForeground(new Color(255, 255, 255));
        panel.add(price);

        priceF = new JTextField();
        priceF.setBounds(200, 170, 150, 30);
        priceF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        priceF.setBackground(new Color(105, 105, 105));
        priceF.setForeground(new Color(255, 255, 255));
        panel.add(priceF);

        JLabel cleaningStatus = new JLabel("Cleaning Status");
        cleaningStatus.setBounds(50, 220, 150, 30);
        cleaningStatus.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cleaningStatus.setForeground(new Color(255, 255, 255));
        panel.add(cleaningStatus);

        cleaningStatusF = new JComboBox(new String[]{"Cleaned", "Dirty"});
        cleaningStatusF.setSelectedIndex(-1);
        cleaningStatusF.setBounds(200, 220, 150, 30);
        cleaningStatusF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        cleaningStatusF.setBackground(new Color(105, 105, 105));
        cleaningStatusF.setForeground(new Color(255, 255, 255));
        panel.add(cleaningStatusF);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(50, 270, 100, 30);
        bedType.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        bedType.setForeground(new Color(255, 255, 255));
        panel.add(bedType);

        bedTypeF = new JComboBox(new String[]{"Single", "Double", "Triple"});
        bedTypeF.setSelectedIndex(-1);
        bedTypeF.setBounds(200, 270, 150, 30);
        bedTypeF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        bedTypeF.setBackground(new Color(105, 105, 105));
        bedTypeF.setForeground(new Color(255, 255, 255));
        panel.add(bedTypeF);

        add = new JButton("Add");
        add.setBounds(200, 350, 100, 30);
        add.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        add.setBackground(new Color(39, 40, 41));
        add.setForeground(new Color(255, 255, 255));
        add.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(95, 350, 100, 30);
        back.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        back.setBackground(new Color(39, 40, 41));
        back.setForeground(new Color(255, 255, 255));
        back.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 255), 2));
        back.addActionListener(this);
        panel.add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/hotelRoom.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label1 = new JLabel(i2);
        label1.setBounds(400, 0, 500, 500);
        panel.add(label1);


        setUndecorated(true);
        setLocation(250, 120);
        setLayout(null);
        setSize(885, 500);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == add) {
            try {
                Con c = new Con();
                String roomNo = roomNoF.getText();
                String availability = (String) availabilityF.getSelectedItem();
                String price = priceF.getText();
                String cleaningStatus = (String) cleaningStatusF.getSelectedItem();
                String bedType = (String) bedTypeF.getSelectedItem();

                String queries = "insert into room values('" + roomNo + "', '" + availability + "', '" + price + "', '" + cleaningStatus + "', '" + bedType + "')";
                c.statement.executeUpdate(queries);

                JOptionPane.showMessageDialog(null, "Room Added Successfully");
                // this.setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
