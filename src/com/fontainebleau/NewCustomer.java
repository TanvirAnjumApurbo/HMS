package com.fontainebleau;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;

public class NewCustomer extends JFrame implements ActionListener {
    JTextField nameF, idNumberF, contactNumberF, countryF, depositF;
    JComboBox idTypeF;
    JRadioButton male, female;
    Choice roomNumberF;
    JButton add, back;

    NewCustomer() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 848, 640);
        panel.setBackground(new Color(39, 40, 41));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        JLabel label1 = new JLabel(i2);
        label1.setBounds(550, 200, 200, 200);
        panel.add(label1);

        JLabel title = new JLabel("New Customer Form");
        title.setBounds(320, 10, 300, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 25));
        title.setForeground(new Color(255, 255, 255));
        panel.add(title);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 70, 100, 30);
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nameLabel.setForeground(new Color(255, 255, 255));
        panel.add(nameLabel);

        nameF = new JTextField();
        nameF.setBounds(200, 70, 150, 30);
        nameF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        nameF.setBackground(new Color(105, 105, 105));
        nameF.setForeground(new Color(255, 255, 255));
        panel.add(nameF);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(50, 120, 100, 30);
        idLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        idLabel.setForeground(new Color(255, 255, 255));
        panel.add(idLabel);

        idTypeF = new JComboBox(new String[]{"Passport", "NID", "Birth Certificate"});
        idTypeF.setSelectedIndex(-1);
        idTypeF.setBounds(200, 120, 150, 30);
        idTypeF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        idTypeF.setBackground(new Color(105, 105, 105));
        idTypeF.setForeground(new Color(255, 255, 255));
        panel.add(idTypeF);

        JLabel idNumberLabel = new JLabel("ID Number");
        idNumberLabel.setBounds(50, 170, 100, 30);
        idNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        idNumberLabel.setForeground(new Color(255, 255, 255));
        panel.add(idNumberLabel);

        idNumberF = new JTextField();
        idNumberF.setBounds(200, 170, 150, 30);
        idNumberF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        idNumberF.setBackground(new Color(105, 105, 105));
        idNumberF.setForeground(new Color(255, 255, 255));
        panel.add(idNumberF);

        JLabel contactNumberLabel = new JLabel("Contact Number");
        contactNumberLabel.setBounds(50, 220, 150, 30);
        contactNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        contactNumberLabel.setForeground(new Color(255, 255, 255));
        panel.add(contactNumberLabel);

        contactNumberF = new JTextField();
        contactNumberF.setBounds(200, 220, 150, 30);
        contactNumberF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        contactNumberF.setBackground(new Color(105, 105, 105));
        contactNumberF.setForeground(new Color(255, 255, 255));
        panel.add(contactNumberF);

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(50, 270, 100, 30);
        genderLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        genderLabel.setForeground(new Color(255, 255, 255));
        panel.add(genderLabel);

        male = new JRadioButton("Male");
        male.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        male.setForeground(new Color(255, 255, 255));
        male.setBackground(new Color(39, 40, 41));
        male.setBounds(200, 270, 70, 30);
        panel.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        female.setForeground(new Color(255, 255, 255));
        female.setBackground(new Color(39, 40, 41));
        female.setBounds(270, 270, 70, 30);
        panel.add(female);

        JLabel countryLabel = new JLabel("Country");
        countryLabel.setBounds(50, 320, 100, 30);
        countryLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        countryLabel.setForeground(new Color(255, 255, 255));
        panel.add(countryLabel);

        countryF = new JTextField();
        countryF.setBounds(200, 320, 150, 30);
        countryF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        countryF.setBackground(new Color(105, 105, 105));
        countryF.setForeground(new Color(255, 255, 255));
        panel.add(countryF);

        JLabel roomNumberLabel = new JLabel("Allocated Room Number");
        roomNumberLabel.setBounds(50, 370, 150, 30);
        roomNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNumberLabel.setForeground(new Color(255, 255, 255));
        panel.add(roomNumberLabel);

        roomNumberF = new Choice();
        try {
            Con c = new Con();
            ResultSet rs = c.statement.executeQuery("select * from room");
            while (rs.next()) {
                roomNumberF.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        roomNumberF.setBounds(200, 370, 150, 30);
        roomNumberF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        roomNumberF.setBackground(new Color(105, 105, 105));
        roomNumberF.setForeground(new Color(255, 255, 255));
        panel.add(roomNumberF);

        JLabel depositLabel = new JLabel("Deposit");
        depositLabel.setBounds(50, 420, 100, 30);
        depositLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        depositLabel.setForeground(new Color(255, 255, 255));
        panel.add(depositLabel);

        depositF = new JTextField();
        depositF.setBounds(200, 420, 150, 30);
        depositF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        depositF.setBackground(new Color(105, 105, 105));
        depositF.setForeground(new Color(255, 255, 255));
        panel.add(depositF);

        add = new JButton("Add Customer");
        add.setBounds(200, 570, 130, 30);
        add.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add.setBackground(new Color(39, 40, 41));
        add.setForeground(new Color(255, 255, 255));
        add.addActionListener(this);
        panel.add(add);

        back = new JButton("Back");
        back.setBounds(60, 570, 130, 30);
        back.setFont(new Font("Segoe UI", Font.BOLD, 14));
        back.setBackground(new Color(39, 40, 41));
        back.setForeground(new Color(255, 255, 255));
        back.addActionListener(this);
        panel.add(back);

        setLayout(null);
        setLocation(400, 45);
        setSize(858, 650);
        setUndecorated(true);
        setVisible(true);

    }

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == add) {
        String name = nameF.getText();
        String idType = (String) idTypeF.getSelectedItem();
        String idNumber = idNumberF.getText();
        String contactNumber = contactNumberF.getText();
        String gender = male.isSelected() ? "Male" : "Female";
        String country = countryF.getText();
        String roomNumber = roomNumberF.getSelectedItem();
        String deposit = depositF.getText();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        try {
            Con c = new Con();

            // Check if the room is already occupied
            String roomAvailabilityQuery = "SELECT availability FROM room WHERE roomnumber = ?";
            PreparedStatement psRoomAvailability = c.statement.getConnection().prepareStatement(roomAvailabilityQuery);
            psRoomAvailability.setString(1, roomNumber);
            ResultSet rsRoomAvailability = psRoomAvailability.executeQuery();
            if (rsRoomAvailability.next()) {
                String availability = rsRoomAvailability.getString("availability");
                if ("Occupied".equalsIgnoreCase(availability)) {
                    JOptionPane.showMessageDialog(null, "Room is already occupied. Cannot allocate this room to a new customer.");
                    return;
                }
            }

            String query = "INSERT INTO customer (name, id_type, id_number, contact_number, gender, country, room_number, deposit, created_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String query2 = "UPDATE room SET availability = 'Occupied' WHERE roomnumber = ?";
            PreparedStatement psCustomer = c.statement.getConnection().prepareStatement(query);
            psCustomer.setString(1, name);
            psCustomer.setString(2, idType);
            psCustomer.setString(3, idNumber);
            psCustomer.setString(4, contactNumber);
            psCustomer.setString(5, gender);
            psCustomer.setString(6, country);
            psCustomer.setString(7, roomNumber);
            psCustomer.setString(8, deposit);
            psCustomer.setString(9, timestamp);
            psCustomer.executeUpdate();

            PreparedStatement psRoom = c.statement.getConnection().prepareStatement(query2);
            psRoom.setString(1, roomNumber);
            psRoom.executeUpdate();

            JOptionPane.showMessageDialog(null, "Customer Added Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else if (e.getSource() == back) {
        this.setVisible(false);
    }
}

    public static void main(String[] args) {
        new NewCustomer();
    }
}
